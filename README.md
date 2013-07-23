ariJ - **a**nother **r**eally **i**nteresting **J**ira 
====
...client for Android. Yes, I came up with this acronym right now.

It's my pet project, I want to learn new stuff, test different approaches using different libraries, so don't expect
well formed codebase, at least at the beginning.

Download
===
[![Google play](https://developer.android.com/images/brand/en_generic_rgb_wo_45.png)](http://play.google.com/store/apps/details?id=com.tadamski.arij)

or [compile it yourself](https://github.com/tmszdmsk/arij/blob/master/README.md#how-to-build-)

Current state
===
* multiple accounts support
* 4 predefined filters to display issues
* comments view/add
* worklog view/add
* allows to start work on issue with timer and log that work later
* assigning tasks to logged in user
* homescreen & lockscreen widget with selected jql query filter results

In progress
===
* user favourite filters
* user defined filters
* tablets support (tablet branch)


Features planned
===
* dashclock provider
* transition between issue states (starting work, stopping it, resolving)
* handling of custom fields
* edition of all issue fields
* plugin for jira to support Google Cloud Messaging to send push notifications
* opening links pointing to jira in application (that will be tricky ;)
* tbc

How to build [![Build Status](https://travis-ci.org/tmszdmsk/arij.png?branch=master)](https://travis-ci.org/tmszdmsk/arij)
===
I care about pom's so it shouldn't be a problem.
Just make sure that your ANDROID_HOME environment variable is set properly.

```bash
mvn validate && mvn install
``` 
and magic should happen ;)
If not - [create an issue](http://github.com/tmszdmsk/arij/issues/new) or write an [e-mail](mailto:tomasz.adamski@gmail.com)

License
===
MIT, details [here](http://github.com/tmszdmsk/arij/blob/master/LICENSE)

Thanks
===
* to [Cogision](http://cogision.com) - me employer, company standing behind [UsabilityTools.com](http://usabilitytools.com) - almost all commits sent 8-12.07.2013 were created during "10% of work time for self development". 
* to [Atlassian](http://atlassian.com) - for opensource license for OnDemand Jira
