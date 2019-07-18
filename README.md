# wowtool

Spring Controller implementation to mimick the features of the WoWArmory (albeit greatly reduced in functionality).

The project will adhere to dependency rules and made as modular as possible such that deployment onto a different platform or
framework (e.g. moving away from Spring framework for another) may only need refactoring of the controller/presenter level.

Milestone goals:

1. Basic implementation of OAuth, retrieval and caching of profiles (using Postgresql or some other industry standard database)
   and Spring controller for functionality testing.
   (Current progress about 70%)
   
2. Thread scheduler and continue developing all of the models and data layer components to represent character profiles
   (Models and implementations for Characters, Items, Guilds, Achievements, etc)
   
3. Unit and integration testing for all of the above before deployment onto a cloud provider (such as AWS or Heroku)

4. Build a front end to access the deployed API in both web format and mobile applications (Native on Android/iOS or React)
