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

- *appium desktop* to manually recreate steps in an Appium session (automated as far as Sauce Labs knows)
- *keep alive sessions* send a non-changing request to keep a session going for analysis
- *interactive commands* ruby appium console, node.js appium-repl, appium-java-repl
- *tracking header* or other identifying mechanism so your network or application layer can know what 
- *browsermob proxy* can intercept requests, modify them, and generate HAR files
- *virtual USB* to interact with the device

## Common issues

- Common error messages
- Element not found
  - timing issues
  - not on right page
- Didn't end session
  - forgot
  - test under development
  - test crashed before cleanup
- Network
  
## Issues beyond your control

- Appium Issues
- WebDriverAgent (IOS)
- Android or IOS platform issues
- Sauce Labs issues





