# Git Android Profile
Android Git Profile

The Android app demonstrates the usage of [Github GraphQL API](https://docs.github.com/en/graphql) to access a Git profile. 
Profile displays main user information (image, name, login, email, followers, following), 3 first of pinned repositories, 10 first of top and starred repositories.

## Technical Details

MVP Architecture is used together with RxJava for reactive programming.

We use [Dragger 2](https://dagger.dev/) for Dependency Injection. The general concept behind dependency injection is called Inversion of Control.

To download Github GraphQL Schema use following command:
./gradlew downloadApolloSchema --endpoint="https://api.github.com/graphql" --schema="app/src/main/graphql/com/wordpress/tharindufit/gitprofile/schema.json" --header="Authorization: Bearer [PERSONAL_ACCESS_TOKEN]"