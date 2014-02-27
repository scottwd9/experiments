# Testing with Protractor

## Why test?
- Unit vs Functional?
- Angular - Karma/Protractor, with Jasmine

## What is Protractor?
- Wrapper around webdriver.js
- A DSL that makes writing tests easier
- Extra angular helpers
- Test angular/non-angular sites

## Documentation
[https://github.com/angular/protractor/tree/master/docs](https://github.com/angular/protractor/tree/master/docs)

- api
- findElements

## Getting started
- Install protractor

```
sudo npm -g install protractor
sudo webdriver-manager update
```

## elementexplorer.js
- Hidden in the protractor install
- Link for easy execution
- Test driver code without running tests

## The DSL
- ```by.<id|css|className|xpath|...>```
- ```element()```
- ```element.all()```
- ```get```
- ```first```
- ```last```
- ```map```
- ```each```

## Angular matchers
- ```by.model```
- ```by.repeater```
- ```by.binding```

## The config

```
exports.config = {
  seleniumAddress: 'http://localhost:4444/wd/hub',
  
  allScriptsTimeout: 5000,

  capabilities: {
    'browserName': 'chrome'
  },

  specs: ['*.spec.js'],

  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 30000
  },
  
  onPrepare: function() {
    ...
  };
};
```

## Writing a test

```
describe('The Angular site', function() {
  it('should greet', function() {
    browser.get('http://www.angularjs.org');

    element(by.model('yourName')).sendKeys('Amplify');

    var greeting = element(by.binding('yourName'));

    expect(greeting.getText()).toEqual('Hello Amplify!');
  });
});
```

## Testing non-angular sites
- ```browser.ignoreSynchronization = true;```


## Promises & Protractor's Jasmine
- ```expect()``` will resolve promises

## Page Objects
- Separate selenium logic from test code
- Less brittle
- More readable
