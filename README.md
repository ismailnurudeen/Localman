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
	        implementation 'com.github.ismailnurudeen:Origin:v0.1'
	}
```


# How to use
**Kotlin** 
```kotlin
val origin = Origin(this)

// get list of all states in Nigeria
val states = origin.getAllStates() 

// get list of all local government areas in Edo State
val lgasInEdo = origin.getLGAs(States.EDO_STATE) 

// get latitude of Edo State
val latInEdo = origin.getLatitude(States.EDO_STATE)  
```
**Java**
```java
Origin origin = new Origin(this)

// get list of all states in Nigeria
ArrayList<String> states = origin.getAllStates()

// get list of all local government areas in Edo State
ArrayList<String> lgasInEdo = origin.getLGAs(States.EDO_STATE) 

// get latitude of Edo State
Double latOfEdo = origin.getLatitude(States.EDO_STATE) 
```

**Check out avialable methods and very useful constants below.**

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


## Constants

## States
| NAME      | VALUE     | NAME      | VALUE     |
|------     |-------    |------     |-------    |
| ABIA | "Abia" | KADUNA | "Kaduna" |
| ADAMAWA | "Adamawa" | KEBBI | "Kebbi" |
| AKWA_IBOM | "Akwa Ibom" | KANO | "Kano" |
| ANAMBRA | "Anambra" | KOGI | "Kogi" |
| BAUCHI | "Bauchi" | LAGOS | "Lagos" |
| BENUE | "Benue" | KATSINA | "Katsina" |
| BORNU | "Borno" | KWARA | "Kwara" |
| BAYELSA | "Bayelsa" | NASARAWA | "Nasarawa" |
| CROSS_RIVER | "Cross River" | NIGER | "Niger" |
| DELTA | "Delta" | OGUN | "Ogun" |
| EBONYI | "Ebonyi" | ONDO | "Ondo" |
| EDO | "Edo" | RIVERS | "Rivers" |
| EKITI | "Ekiti" | OYO | "Oyo" |
| ENUGU | "Enugu" | OSUN | "Osun" |
| FCT | "Federal Capital Territory" | SOKOTO | "Sokoto" |
| GOMBE | "Gombe" | PLATEAU | "Plateau" |
| JIGAWA | "Jigawa" | TARABA | "Taraba" |
| IMO | "Imo" | YOBE | "Yobe" |
| ZAMFARA | "Zamfara" |

## Geo-Political Zones
| NAME      | VALUE     |
|------     |-------    | 
|NORTH_CENTRAL  | "North Central" |
|NORTH_EAST  | "North East" |
|NORTH_WEST  | "North West" |
|SOUTH_SOUTH  | "South South" |
|SOUTH_EAST  | "South East" |
|SOUTH_WEST  | "South West" |

## Bugs and Feedback
For bugs, feature requests, and discussion please use GitHub Issues. For general usage question or feedback please contact me via [ibrightstar247@gmail.com](mailto:ibrightstar247@gmail.com) and follow me on [Twitter](www.twitter.com/TeenMutantCoder).
