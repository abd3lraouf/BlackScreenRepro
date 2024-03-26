# BlackScreen Minimal reproduction project

This project is a minimal reproduction project for the issue I am facing with the black screen during 
fragment transitions when wrapped inside compose 
see [ContainerFragment.kt](app/src/main/java/dev/abd3lraouf/blackscreenrepro/ContainerFragment.kt)

## Issue
When I navigate from `FirstFragment` to `SecondFragment` the screen goes black for a moment before 
showing the `SecondFragment` content making an incorrect transition, also when I navigate back to 
`FirstFragment` from `SecondFragment`.

## Correct behavior
You should be able to see the correct behaviour on this branch [correct-behavior](https://github.com/abd3lraouf/BlackScreenRepro/tree/correct-behavior)
