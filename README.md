## Blibli-Testing-Framework
Testing Framework for Blibli Android and Web App

[![traveloka-icon](https://user-images.githubusercontent.com/12959761/45268447-c6f02d80-b4a6-11e8-9ed3-f59ca323cfe0.png)](https://www.blibli.com/)

This Blibli framework is Java implementation of the [Appium](https://github.com/appium/appium)
framework and [Selenium](https://github.com/SeleniumHQ/selenium) software-testing framework with [TestNG](https://github.com/cbeust/testng) 
testing framework to create easy automate testing for Blibli Android Application which written in Java & XML.

This testing framework is applying the automation build using [Maven](https://maven.apache.org/) and [Jenkins](https://jenkins.io/) 
with GitHub to help manage the deployment process so continuous integration for testing can be achieved.

### Development Technology
Included in `pom.xml` for maven dependency
* [Selenium](https://github.com/SeleniumHQ/selenium)
* [Appium](https://github.com/appium/appium)
* [TestNG](https://github.com/cbeust/testng)

### Build Automation Tools
* GitHub
* [Maven](https://maven.apache.org/)
* [Jenkins](https://jenkins.io/)

### Supported Platforms
* Android
* Web Application

### API Features
* Wait Get Element By ID, ClassName, XPath, CSSSelector
* Wait for Click Element By ID, ClassName, XPath, CSSSelector
* Wait to Send Keys Element By ID, ClassName, XPath, CSSSelector
* Wait to Get Elements By ID, ClassName, XPath, CSSSelector
* Wait Get Elements By ID, ClassName, XPath, CSSSelector (Support index)
* Wait Click Elements By ID, ClassName, XPath, CSSSelector (Support Index)
* Tap By Coordinates
* Swipe Vertically, Horizontally, & By Coordinates
* WaitInvisibilityByCssSelector
* Delay

### Suites Capabilities:
* Test Suites (Collection of Test Cases)
* Multiple Test Suites
* Parallel Execution (Multithreading) Test
* Multiplatform Parallel Execution Test (e.g. Android & Web at the same time)

### Functionality Capabilities:
**Splash Screen: (Android & Web)**
* Skip Splash Screen

**Home: (Android & Web)**
* Search
* Kategori Belanja

**Search: (Android & Web)**
* Sort / Order By
* Filter by Brand
* Filter by Price
* Filter by Seller Location
* Select
* Print Item List

**Login: (Android & Web)**
* Login with Username & Password

**Summary: (Android & Web)**
* Pick Size
* Add Quantity
* Add to Cart
* Buy Now

**Delivery: (Android & Web)**
* Choose Courrier
* Continue to Payment

**Checkout: (Android Only)**
* Continue

**Payment: (Android & Web)**
* Transfer
* Indomaret
* Pay Now

**ThankYou: (Android & Web)**
* Print Payment Code (Can be used for tracking order in the database)

### Examples
**Flight Purchase:**
* Automation Test for Web app
[![test_web](https://user-images.githubusercontent.com/12959761/45268861-e179d500-b4ad-11e8-9ec1-7b0245c5d554.png)](https://youtu.be/7npnRPdU-Qs)

* Continuous Integration using Jenkins for Android app
[![test_android_jenkins](https://user-images.githubusercontent.com/12959761/45268873-fd7d7680-b4ad-11e8-80fe-a7473afcc2dd.png)](https://youtu.be/gK7C_G0KfSs)

* Multiplatform Parallel Execution (Multithreading)
[![multiplatform_parallel_test](https://user-images.githubusercontent.com/12959761/45274445-ac877580-b4e1-11e8-954d-3a66aafdf008.png)](https://youtu.be/FojivtKSU5U)

### Authors
Ivan Widyan - Creator & Developer (ivanwidyan@yahoo.com)