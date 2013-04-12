# Calculates the number of miles you need to run by today to run a given
# amount this year.

from datetime import date
import sys

miles = 1000
if(len(sys.argv) > 1):
    miles = float(sys.argv[1])

today = date.today()
year_begin = date(today.year, 1, 1)
year_end = date(today.year + 1, 1, 1)

year_pcnt = (today - year_begin).total_seconds() / (year_end - year_begin).total_seconds()

print('You should have run {0:.0f} miles by the end of the day.'.format(year_pcnt * miles))
