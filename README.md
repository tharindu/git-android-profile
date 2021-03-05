# Git Android Profile
Android Git Profile

The Android app demonstrates the usage of [Github GraphQL API](https://docs.github.com/en/graphql) to access a Git profile. 
Profile displays main user information (image, name, login, email, followers, following), 3 first of pinned repositories, 10 first of top and starred repositories.

To query Git Profile User data, please open `config.properties` file and set your github personal acccess token.
```GIT_PERSONAL_ACCESS_TOKEN = "abcdefghijklmnopqrstuvwxyz1234567890"```

## Technical Details

MVP Architecture is used together with RxJava for reactive programming.

To download Github GraphQL Schema we could use following command:

```./gradlew downloadApolloSchema --endpoint="https://api.github.com/graphql" --schema="app/src/main/graphql/com/wordpress/tharindufit/gitprofile/schema.json" --header="Authorization: Bearer [PERSONAL_ACCESS_TOKEN]"```

## Screenshots

[[https://github.com/tharindu/git-android-profile/blob/main/images/screen_1.png|Profile1]]

[[https://github.com/tharindu/git-android-profile/blob/main/images/screen_1.png|Profile2]]