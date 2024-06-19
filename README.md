![Circle Menu](https://res.cloudinary.com/dqxo6zuw7/image/upload/v1598180618/Circle_Menu_bsq21v.png)

**CircleMenu**

[![Release](https://jitpack.io/v/Leeeeeeelo/CircleMenu.svg)](https://jitpack.io/#Leeeeeeelo/CircleMenu) ![minSDK](https://img.shields.io/badge/minSdkVersion-24-blue.svg)

## Table of Contents
1. [Setup](#setup)
2. [Examples](#examples)
3. [Documentation](#documentation)
4. [Origin & Attribution](#origin-attribution)
5. [Notice](#notice)
6. [License](#license)

## 1. Setup :hammer_and_wrench:

First, add the JitPack repository to your build file.
```gradle
repositories {
	...
	maven { url 'https://jitpack.io' }
}
```
Second, add this project as a dependency.
```gradle
dependencies {
	...
	implementation 'com.github.leeeeeeelo:circlemenu:1.0.0'
}
```

## 2. Examples :eyes:

⭕ Simple Circle Menu:

![Simple Circle Menu](https://raw.githubusercontent.com/Leeeeeeelo/CircleMenu/master/art/preview_simple.gif)

⭕ Circle Menu With Bottom App Bar:

![Bottom App Bar Circle Menu](https://raw.githubusercontent.com/Leeeeeeelo/CircleMenu/master/art/preview_bottom_bar.gif)

⭕ Corner Circle Menu:

![Corner Circle Menu](https://raw.githubusercontent.com/Leeeeeeelo/CircleMenu/master/art/preview_fab.gif)

## 3. Documentation :notebook_with_decorative_cover:

Add to your layout xml file the below:

```xml  
<com.leeeeeeelo.circlemenu.CircleMenu  
	android:id="@+id/circleMenu"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	app:buttonColors="@array/colors"
	app:buttonIcons="@array/icons" />  
```  

Handling menu items clicks:

```kotlin  
val circleMenu = findViewById<CircleMenu>(R.id.circleMenu)  
circleMenu.setOnItemClickListener { buttonIndex -> }  
```  

You can use ```open(boolean animate)```, ```close(boolean animate)``` and ```toggle(boolean animate)``` methods, to open and close menu programmatically:

```kotlin  
circleMenu.open(true)  
```  

Set EventListener for handling open/close actions

```kotlin  
circleMenu.setOnItemClickListener { buttonIndex -> }  
  
circleMenu.onMenuOpenAnimationStart { }  
  
circleMenu.onMenuOpenAnimationEnd { }  
  
circleMenu.onMenuCloseAnimationStart { }  
  
circleMenu.onMenuCloseAnimationEnd { }  
  
circleMenu.onButtonClickAnimationStart { buttonIndex -> }  
  
circleMenu.onButtonClickAnimationEnd { buttonIndex -> }  
```  

Below are the Circle Menu attributes:

- `buttonIcons` **(required)** - Array of icons of menu buttons
- `buttonColors` **(required)** - Array of background colors of menu buttons
- `iconsColor` - Array of color of buttons icons  
  <br>
- `startAngle` - Start circle angle
- `maxAngle` - Maximum degree of the menu arc
- `distance` - Distance between center menu and buttons (radius)
- `centerButtonColor` - Background color of center menu button
- `centerButtonIconColor` - Icon background color of center menu button  
  <br>
- `menuIcon` - Center button icon type. One of  `hamburger` or `plus`
- `openOnStart` - Bool to open the menu when the screen starts
- `showSelectAnimation` - Bool to display animation when clicking on a button or closing the menu

## 4. Origin & Attribution  :scroll:

This project is a **fork** of [Circle Menu](https://github.com/ImangazalievM/CircleMenu), created by [ImangazalievM](https://github.com/ImangazalievM) and licensed under the [MIT License](https://github.com/ImangazalievM/CircleMenu?tab=readme-ov-file#-license).

I was looking for a menu library myself when I stumbled upon [Circle Menu by ImangazalievM](https://github.com/ImangazalievM/CircleMenu). However it was retired, not up to date and had some bugs. This library is a result of a fork from the original library with the addition of some work of my own to improve it and keep it up to date. All the credits goes to [ImangazalievM](https://github.com/ImangazalievM) for the original amazing work !

### Changes in this Fork
- Updated Gradle
- Updated Java version
- Updated ```minSDK``` and ```targetSDK```
- Fixed bugs
- Added visibility support
- Released via JitPack

## 5. Notice  :warning:
This product includes software developed by [ImangazalievM](https://github.com/ImangazalievM).

## 6. License  :page_facing_up:

This library is licensed under the MIT License. See the [MIT License](https://opensource.org/license/mit) license for more details.

```  
Copyright 2024 Elias Sayegh

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```