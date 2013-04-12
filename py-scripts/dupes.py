# Deletes duplicate files in a given directory based on md5 hash

import sys
import os
import hashlib

def md5(file):
    md5 = hashlib.md5()
    with open(file,'rb') as f:
        md5.update(f.read())
    return md5.hexdigest()

def remove_duplicates(base_dir, delete_files, cleanup_dirs):
    examined_file_md5s = {}

    for root, dirs, files in os.walk(base_dir):
        for name in files:
            crnt_file = os.path.join(root, name)
            file_md5 = md5(crnt_file)

            if file_md5 not in examined_file_md5s:
                examined_file_md5s[file_md5] = crnt_file
            else:
                if delete_files:
                    print("deleting duplicate file: " + crnt_file + ", orig: " + examined_file_md5s[file_md5])
                    os.remove(crnt_file)
                else:
                    print("duplicate file: " + crnt_file + ", orig: " + examined_file_md5s[file_md5])

    if cleanup_dirs:
        remove_empty_dirs(base_dir)

def remove_empty_dirs(base_dir):
    for root, dirs, files in os.walk(base_dir):
        for name in dirs:
            crnt_dir = os.path.join(root, name)
            if not os.listdir(crnt_dir):
                print("removing empty directory: " + crnt_dir)
                os.rmdir(crnt_dir)

if __name__ == "__main__":
    opt_delete_files = False
    opt_delete_empty_dirs = False

    if len(sys.argv) < 2:
        print("dupes.py <directory> <really-delete-files?> <cleanup-empty-directories?>")
        sys.exit()

    if len(sys.argv) >= 3 and sys.argv[2] == '1':
        opt_delete_files = True
        print("Duplicate files will be DELETED!")
    else:
        print("Dry run, no files will be deleted.")

    if len(sys.argv) >= 4 and sys.argv[3] == '1':
        print("Empty directories will be DELETED!")
        opt_delete_empty_dirs = True

    remove_duplicates(sys.argv[1], opt_delete_files, opt_delete_empty_dirs)
