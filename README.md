# Rat checker
this project is a checker for virus's and token loggers in java apps<br>
this project is not finished and when it is it will never be perfect. <br>
the goal of this project is to be able to replace [theia](https://github.com/Tigermouthbear/Theia) because it is not in development anymore and there are quite a lot of simple bypasses for it. <br>

## Contributions

this project would never be made without references to [theia](https://github.com/Tigermouthbear/Theia) as this is how i am learning asm

## Roadmap

[v] - finished<br>
[/] - started/almost finished<br>
[x] - havent started<br>

### ui
   [/] - gui <br>
   [x] - save log to file<br>
   [x]  - different themes<br>

### techniques
   [x] - string deobfer <br>
   [x] - webhook check <br>
   [x] - web connection check <br>
   [x] - socket check <br>
   [v] - exit checks <br>
   [x] - classload checks <br>
   [v] - process check (command check) <br>
   [v] - coord check <br>
   [x] - file deletion check <br>
   [v] - file check (checks for opening files) <br>
   [x] - string checks (checks for strings with certain keywords) <br>
   [v] - url check <br>
   [x] - ip check <br>
   [v] - system checks (system.getProperty and system.getenv) <br>
   [x] - dependency checks (checks if dependencies are the right size because people sometimes put virus's in dependencies) <br>
   
## Images

![Gui](https://i.gyazo.com/9460ff3bd92b15f04c003b4a053c39e5.png)

## Usage

### Basic usage

Step 1) Click choose file and select the file that you want to choose. <br>
Step 2) Open the config tab and select what checks you want to use <br>
Step 3) Click the run button. <br>
Step 4) Open [recaf](https://github.com/Col-E/Recaf/releases/tag/2.17.2) and investage the classes <br>

### What to look for
Investigate every url check and property checks, and every file check that does not look like it is for a config system (it could be spying on you) <br>
more indepth coming soon
