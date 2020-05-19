## 使用AndroidX的测试


1. 在`app/build.gradle`添加依赖

```groovy
testImplementation 'org.robolectric:robolectric:4.3.1'
// 下面的testImplementation依赖和androidTestImplementation一样
// 只是利用robolectric模拟运行环境
testImplementation 'androidx.test.ext:junit:1.1.1'
testImplementation 'androidx.test.ext:truth:1.2.0'
testImplementation 'androidx.test.espresso:espresso-core:3.2.0'
testImplementation 'androidx.test.espresso:espresso-intents:3.2.0'

androidTestImplementation 'androidx.test.ext:junit:1.1.1'
androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
androidTestImplementation 'androidx.test.espresso:espresso-intents:3.2.0'
androidTestImplementation 'androidx.test.ext:truth:1.2.0'
```

2. 在`app/build.gradle`里添加

```groovy

android {
   // 引入robolectric库时需要添加的
    testOptions {
        unitTests {
            includeAndroidResources = true
        }
    }
}

```