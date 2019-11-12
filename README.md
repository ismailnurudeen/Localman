[![](https://jitpack.io/v/ElNuru247/Origin.svg)](https://jitpack.io/#ElNuru247/Origin)

# Origin
An Android library that provides Nigerian based location data list and info such as States,Local Government Areas,Cities etc...

## Setup
- To use the library in your projects,follow the steps below;

### Step 1. Add the JitPack repository to your build file:

Add it in your root build.gradle at the end of repositories
```gradle
	 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	} 
```
### Step 2. Add the dependency:

Add this in your app build.gradle where you have your dependencies
```gradle
	 dependencies {
	        implementation 'com.github.ElNuru247:Origin:v0.1'
	}
```


# How to use
**Kotlin** 
```kotlin
val origin = Origin(this)
val states = origin.getAllStates() 
```
**Java**
```java
Origin origin = new Origin(this)
ArrayList<String> states = origin.getAllStates()
```
	
## Available Methods

| METHODS                            	| DESCRIPTION                                                                                                                                                           	| RETURN VALUE      	|
|------------------------------------	|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------	|-------------------	|
| getAllLGAs()                       	| * Returns an ArrayList of all the Local Government Areas in Nigeria                                                                                                   	| ArrayList<String> 	|
| getAllStates()                     	| * Returns an ArrayList of all the States in Nigeria                                                                                                                   	| ArrayList<String> 	|
| getLGAs(state: String)             	| * Returns an ArrayList of all Local Government Areas (LGAs) in a state.<br>     * @param state  The State to get the LGAs from                                        	| ArrayList<String> 	|
| getCities(state: String)           	| * Returns an ArrayList of all cities in a state.<br>     * returns an empty array if none is found.<br>     * @param state  The State to get the cities from.         	| ArrayList<String> 	|
| getCapital(state: String)          	| * Returns the capital city of a state.<br>     * @param state  The State to get capital from.                                                                         	| String            	|
| getLGAState(lga: String)           	| * Returns the state a local government area is found in.<br>     * returns @Null if local government area does not exist<br>     * @param lga  Local Government Area. 	| String?           	|
| getCityState(city: String)         	| * Returns the state a city is found in.<br>     * returns @Null if city is not found in any state<br>     * @param city  City to get state from.                      	| String?           	|
| getLatitude(state: String)         	| * Returns the latitude of a state.<br>     * @param state  The State to get latitude from.                                                                            	| Double?           	|
| getLongitude(state: String)        	| * Returns the longitude of a state.<br>     * @param state  The state to get longitude from.                                                                          	| Double?           	|
| getMaxLatitude(state: String)      	| * Returns the maximum latitude of a state.<br>     * @param state  The state to get maximum latitude from.                                                            	| Double?           	|
| getMinLatitude(state: String)      	| * Returns the minimum latitude of a state.<br>     * @param state  The state to get minimum latitude from.                                                            	| Double?           	|
| getMaxLongitude(state: String)     	| * Returns the maximum longitude of a state.<br>     * @param state  The state to get longitude from.                                                                  	| Double?           	|
| getMinLongitude(state: String)     	| * Returns the minimum longitude of a state.<br>     * @param state  The state to get minimum longitude from.                                                          	| Double?           	|
| getGeoPoliticalZone(state: String) 	| * Returns Geo Political Zone of a State<br>     * @param state  The State to get Geo Political Zone from.                                                             	| String?           	|
