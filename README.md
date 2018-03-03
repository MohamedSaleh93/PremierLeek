# Premier Leek

It is a simple android application that you can use to figure out the next fixtures that will be played,
knowing the result of current day fixtures and also you can add some fixtures to your favorite so you can always focus on it anytime.

## Getting Started

The app built to make every item is separated to each other, the view is separated to the ui model provider and 
the UI model provider is separated to the network model provider. <br/>
How the app component contact to each other is declared in the next figure:
<a name="Figure1"></a><img src="app_diagram.png?raw=true" width="640" title="Figure 1: app architecture design" /> <br />
</p>

## Libraries used
* <a href="https://github.com/jd-alexander/LikeButton?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=3038" >Like Button </a>
 this library us used for adding the favorite button in the fixtures list with it is animation. <br/>
* <a href="https://github.com/JodaOrg/joda-time">Joda time</a> Joda-Time provides a quality replacement for the Java date and time classes 
it is very helpful if you want to work with formatting dates or any process you want to make with dates on your app <br/>

* <a href="http://square.github.io/retrofit/">Retrofit2 </a> it is a very helpful library that is used with any api calls in your app <br/>
* <a href="https://github.com/google/gson">Gson </a> it is a Java library that powered by google which can be used to convert Java Objects into their JSON representation.  

## References
* <a href="https://www.football-data.org/">Football data </a> it is the data provider that used to get all the information about the premier league in this app