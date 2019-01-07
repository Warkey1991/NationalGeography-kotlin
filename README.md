## NationalGeography use kotlin
###这篇文档是在项目中学习Kotlin语言的语法和Android app开发中所遇到的问题集锦

#### 语法篇
1. **变量和常量的定义**: var ---变量， val---常量。(Swift语言中，常量用let 定义)如项目中用到的,也是可以类型推断的。
   ```kotlin
   var context: Context? = null
   val TYPE_BANNER = 0
   val TYPE_RECOMMEND = 1 // 不指定类型，编译器根据赋值推断出是int型
   ```
   
2. **单例**：因为Android APP项目 首先进入的是Aplication中，该类在进程中唯一，所以需要在很多地方引用到该类中的context, <br>
            因此在此实现了单例，使用关键字object 实现单例。
   ```kotlin
   class App : Application() {
       companion object {
           var instance: App by DelegatesExt.notNullSingleValue()
       }
   
       override fun onCreate() {
           super.onCreate()
           instance = this
       }
   }
   ```
3. **companion object和object的区别**：[区别](http://liuqingwen.me/blog/2017/06/20/object-vs-companion-object-in-kotlin/)
4. **委托的概念和使用**: 2中单例的实现就用到了委托的概念：在委托模式中，当有两个对象参与处理同一个请求是，
                      接受请求的对象将请求委托给另一个对象来处理。委托模式已证明是实现继承的一个很好的替代方式。
                      Kotlin中委托分为类委托和委托属性，Kotlin官方库也封装了一些常用的委托。
     [委托](https://juejin.im/entry/59ac33a36fb9a02491751e97)
   - 类委托：
   - 属性委托：语法：val/var <属性名>: <类型> by <表达式>
   ```kotlin
   var instance: App by DelegatesExt.notNullSingleValue()
   ```
     

