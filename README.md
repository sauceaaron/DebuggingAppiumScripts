# Debugging Appium Scripts


## Artifacts 

Several artifacts are available for helping you to deduce when something goes wrong with a test.
Sauce Labs makes the following available:

- *Video* of the recorded test to replay what happened
- *Screenshots* of every detected change
- *Metadata* to recreate the test settings
- *Command history* to reproduce the test steps
- *Appium server log* and *Device log*

## Additional features

Sauce Labs also has some features available to assist with debugging:

- *manual override* to take over an automated session by clicking on a running video.
- *sauce:break* to pause tests at a specified time using the Sauce Javascript Executor injected in the browser
    - https://wiki.saucelabs.com/display/DOCSDEV/Annotating+Tests+with+Selenium%27s+JavaScript+Executor

- *sauce:context* to add comments in the command history
- *test status, test name, build tag, & custom tags* can be set in capabilities, during a test via JS executor, or afterwards via the Sauce REST API.
- *extended debugging* (currently available for chrome sessions only)

There are some other things you can do to help with debugging:

- *logging* good client side logging is essential
- *stack traces* throw exceptions when you code is not in an expected state (e.g. not on the page you expected)
- *debugging* step through your code with 
- *synchronization* using proper wait strategies
- *code structure* make sure you are using easy to follow abstractions such as the Page Object Pattern 

And a few tricks:

- *keep sessions alive* send a non-changing request to keep a session going for analysis
    - https://gist.github.com/sauceaaron/6e463d9e4c2ed418c1a03a1b95affa26
- *appium desktop* to manually recreate steps in an Appium session (automated as far as Sauce Labs knows)
- *interactive commands*  appium ruby console, node.js appium-repl, appium-java-repl
   - https://github.com/appium/ruby_console
   - https://www.npmjs.com/package/appium-repl
   - https://github.com/mobileboxlab/appium-java-repl
- *tracking header* or other identifying mechanism so your network or application layer can know what 
- *browsermob proxy* can intercept requests, modify them, and generate HAR files
- *virtual USB* to interact with the device

## Common issues

- Common error messages
   - https://wiki.saucelabs.com/display/DOCS/Common+Error+Messages
    
- Element not found
  - timing issues
  - not on right page
- Didn't end session
  - forgot
  - test under development
  - test crashed before cleanup
- Network
    - Sauce Connect
    - Firewall
    - Web Services
      
## Issues beyond your control

- Appium issues
- WebDriverAgent (IOS)
- Android or IOS platform issues
- Sauce Labs issues
- Network issues

## Collecting Data
- Run the same tests over time under the same conditions (build, environment, capabilities)
- Try different settings to see if the problem persists (is it IOS only, iPhone 8 only, Simulator only, Sauce Only, etc.)
- Sauce Analytics dashboard -- especially helpful if you've been setting test name & build tag
- Statistical data with Sauce Errors API
    - https://github.com/sauceaaron/erroredtests

