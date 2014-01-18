# 1/16/14

## Keynote

Future
- 1.3 will be 2.0?  browsers of tomorrow
- Benchmarking, lazy loading es6 modules, Object.observe/polyfills
- Mobile: offline support, reduce initial load, flagship app
- API Complexity: simplify directives, DI

zone.js - long stack traces, no need to call $digest/$apply
diary.js - console, server (analytics)

## AngularJS in 20ish Minutes

##Writing a Massive Angular App


### Auth

Before: active user profile (name, permissions), on app scope, problems with testing, couldn't pass profile to services.

Better: inject profile as JS object, used to create injectible activeProfile service. server-side check for authenticated, if not, redirect to login page.

### Conditional features

load only features needed.

- server side rendering: check auth, include necessary JS.
- controllers inject activeProfileService, check necessary permissions.
- ng-show/ng-hide keeps markup on page, bad for PERFORMANCE. data-keep/data-omit directives. intercept $http, look for attributes. http-response-interceptor.

### Code Organization Patterns

JSFiddles available for all examples.

- Inheritance: BaseListController
- Mixins: angular.extend($scope, someMixinFunction)
- JavaScript Objects: $scope.sorter = new Sorter();
- Composition with Services:
- Composition with Helper Controllers: instantiate with $controller to get DI.

Prefer composition over inheritance. Minimize mixins. Single responsibility.

### Beyond Angular's Services

#### api service

- wraps $http
- exposed with angular provider
- returns a model, instead of json
- use $injector.instatiate for models for DI
- transform model object, on prototype, beforeSave(pre-PUT/POST)/afterLoad(post-GET). enables app-level cacheing, abstracts away server-side.

code for api/fakeApi service is available on github.

## Going Postal with Promises

All about async. callbacks are meh. pyramid of doom, large callback functions.

Promises are not syntax replacement for callbacks.

    step1.
        then(step2).
        then(step3).

each step returns a promise. parallellism:

    $Q.all([as1, as2, as3]).
        then(step4)

a promise is a mailbox, where you can store information about the (non)completion of a process. the deferred is the postman.

1. consume promises ($http, $timeout and friends)
2. $resource calls return promises bobRes.$promise
3. $route:resolve controllers don't have to deal with promises to load data
4. ng1.2 does not unwrap promises in views
5. create promises with $Q
6. angular-ui-bootstrap, ng-modal promise workflow
7. wrap promises in angular service
8. interceptors, $http lifecycle

## Deep Dive into Custom Directives

- use unique prefix, not ng- or ui-
- wrap jquery plugins with directives.
- put directives in their own modules

PERFORMANCE: ng-if use watch? most built-in directives use ng-watch

PERFORMANCE: use classes for different tools? bindonce so you don't watch the toolType? bo-class from https://github.com/Pasvaz/bindonce

directive $attrs do not create watches. use $attrs.observe if needed

## Improving User Experience with Progressive Saving

Use localStorage to store WIP.
Breeze import/export APIs. entity manager

## Rapid Prototyping using Angular & Deployd

## Rich Object Models & Angular

getting data: $resource, restangular, BreezeJS

## Angular Weapon Defense

drones!

## Filters: Beyond OrderBy and LimitTo

## Awesome Interfaces with Angular Animation

transitions, keyframes, js animations
built-in directives are animation-aware

include angular-animate.js
set ngAnimate as module dep
CSS class reference to reference animations

how an animation happens

1. scope change
2. directive triggers DOM operation
3. looks up animations with className
4. animations run
5. animate before -> DOM -> after
6. animations closed

$animate to trigger animations in directives

DOM callback events in 1.2.9

## Dependency Injection

Why DI? Move dependency config into modules, so the envirionment isn't responsible for setting up dependencies.

Why new DI Framework?

- RequireJS
- code minification
- complex (controller, constant, config, run, ...)
- lazy loading code
- singleton only.

Written in ES6, uses transpiler.

## Angular Team Panel

### What kind of performance optimizations should be leveraged?

Keep DOM small. No point in rendering offscreen elements. Use infinite scrolling.

use ng-if, which removes things from DOM

### Virtual DOM in React.JS, possible in Angular?

### Pain points in Angular.

simplify UI, documentation.

### ui-router in angular

possibly, learning from both routers. communication with ui-router team ongoing.

### AMD support

module support will be baked in with the new DI framework. Angular 2.0, soon. Transpiler can be in commonJS or requireJS.

1.3 many improvements in injector.

### SPA auth in Angular

??? - doublelcick talk? cookies vs tokens blog post.

- use interceptors to look for unauthorized, session expiry.
- check cookies.

### Angular 2

no support for IE8 in angular 2

### avoiding memory leaks

call done function in javascript animations.
don't compile a chunk of DOM and don't attach to document, that memory is retained.

### best practice for modularizing app

organize by feature, instead by type. fractal directory structure.

singletons (services, etc) in folder.
controllers/views in nested structure by feature.

### biggest challenge for angular over next few years?

dealing with success.

### bindonce?

1.3

### replace dirty checking

object.observe coming soon!

10k bindings per millisecond.

### angular on the server, pre-rendering?

tomorrow. is this just a hack, it doesn't seem like this is the future.

### mobile performance, 60fps

addressed in keynote. dirty-checking. ionic.

### lazy loading

dan wahlin's site

# 1/17/2014

## Angular === Community & New Web Standards

## TypeScript

## Building Realtime Apps with Angular and Firebase

What is firebase?

- realtime application platform
- api to store/sync data in realtime
- login - auth users
- data security, declarative security rules

extends angular's 2-way data binding to 3-way, adding persistence on server. pretty much makes meteor a thing of the past.

## Angular Directives that Scale

(What I learned from Angular Kendo UI)

## Dart, it's Angular too.

## Zone.js

What?

- domains in Node
- threadlocals in java

it's an execution context. tasks run in the same zone in which they were registered. it's transitive.

long stack traces. find where things were bound. buttons clicked. etc.

no more $rootScope.$apply() in angular 2.0

http://github.com/angular/zone.js

## Angular with Browserify

- require('modules') for the browser, alternative to requireJS or AMD.
- uses commonJS module format.
- synchronous

walks the dependency graph, bundles into single file, wrapped in closure. sourcemaps.

can use NPM.

browserify provides browser-friendly shims of node services, normally not available in the browser.

## Angular + RequireJS & Angular Decorators

Angular injects instances.
RequireJS injects classes (references to functions).

### RequireJS

Dependency types

- load
- construction
- runtime
- module

RequireJS gives you
- dependency manager
- injector (not angular's injector)
- file loader
- concat/uglify

APIs
- define() defines dependency and register's factory function
- require() callback function when dependencies resolved
- config()

every file must be wrapped in a define(). builds a tree of dependencies. nothing happens until you require().

how do you use require with angular?

- use define() around modules
- use define() around all your code
- use config() to set paths
- use require() to bootstrap app

Quizzler demo on github.

grunt supports requirejs using grunt plugin.

No time for decorators. sadface

## Angular and PhoneGap (Cordova)

angular-phonegap-ready

AngularJS for mobile

- ngTouch module
- github.com/ftlabs/fastclick
- github.com/wzr1337/angular-gestures - based on hammer.js
- angular-jqm - jquery mobile, only uses CSS, not the JS

## Arduino

## Protractor

flaky, debugging?

Getting webdriver running?

- webdriver-manager
- saucelabs integration

protractor --sauceUser=??? -sauceKey=???

if it can be a unit test, it should be a unit test.

config is similar to karma, uses jasmine. familiar things.

page objects pattern. separate code for finding elements from test logic.

browser.waitForAngular(), automatically called by protractor.

### element explorer!!!!!!!!!!!!!!!!!!!!!!!!

$ npm -g install protractor
$ webdriver-manager start
$ /usr/local/lib/node_modules/protractor/bin/elementexplorer.js localhost:8000/workspace.html

TAB in the command line, test your selectors

## ngModelController

## Angular Performance

directives inside repeater, link and constructor called once per iteration. get as much as possible done in the compile step.

transclusion, good for limiting scope $digests

use $digest instead of $apply. $apply = $digest + some error handling callbacks and other stuff.

$watch(valueExp, changeExp, deepComparison?), make sure valueExp is fast, avoid deepComparison when possible.

use watchCollection, like a 1-level deep comparison.

$watch only what is needed. don't watch large objects when you care about a subset of fields on that object.

ng-repeat 'track by $index' it will reuse DOM nodes and re-bind things when data changes.

ng-if removes things from DOM, reduces bindings. favor over ng-show. ng-switch is like ng-if.

$$postDigest register callback to be called when current $digest cycle completes. ($$ means private in angular.)

fast-bind-once - https://github.com/kseamon/fast-bind

Tools
- Batarang
- Profiler (don't use minified)
- performance.now()
