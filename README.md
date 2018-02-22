### Setup
1. On C:/ create new folder "bootcamp"
2. In folder Desktop open git bash and fo: `git clone https://github.com/KristineK/new_project.git`
3. In IDEA open project `new_project` from "~/Desktop/new_project"
4. In IDEA check in project structure, that:
   * Project has Project SDK: 1.8
   * Modules has "new_project" with "src" folder selected as "Sources"
   * Libraries has all the jars from "lib" folder:
     * hamcrest-core-1.3
     * junit-4.12
     * selenium-server-standalone-3.4.0
5. In git bash do `git checkout -b "<name_surname>"` 
Note: replace <name_surname> with your name and surname
6. In IDEA go to Sample1.java and change line 27 to `Thread.sleep(50000);`
5. In git bash do 
   * `git add  src/selenium/sample1/Sample1.java` for adding 1 file or `git add .` for all the changes files
   * `git commit -m "increase sleep"`
   *  `git push origin <name_surname>` 
   Note: replace <name_surname> with your name and surname

### Feedback
https://trello.com/invite/b/1P90Yjg9/5e24c5b205572d5c9b00ef18d284471f/bootcamp

### Samples and SampleTask so far...
* Opening a page and printing out url/page title:
    * [Sample1.java](../master/src/selenium/sample/Sample1.java)
    * [Sample1Task.java](../master/src/selenium/sample/Sample1Task.java)
* Locators (id, class, name):
    * [Sample2.java](../master/src/selenium/sample/Sample2.java)
    * [Sample2Task.java](../master/src/selenium/sample/Sample2Task.java)
* Asserts:
    * [Sample3.java](../master/src/selenium/sample/Sample3.java)
    * [Sample3Task.java](../master/src/selenium/sample/Sample3Task.java)
* Actions (click, send keys):
    * [Sample4.java](../master/src/selenium/sample/Sample4.java)
    * [Sample4Task.java](../master/src/selenium/sample/Sample4Task.java)
* Alerts:
    * [Sample5.java](../master/src/selenium/sample/Sample5.java)
    * [Sample5Task.java](../master/src/selenium/sample/Sample5Task.java)
* Locators (xPath, CSS):
    * [Sample6.java](../master/src/selenium/sample/Sample6.java)
    * [Sample6Task.java](../master/src/selenium/sample/Sample6Task.java)
    
### TBC Samples
* Actions (checkbox, radio button and option selector) + bonus of calendar:
    * [Sample7.java](../master/src/selenium/sample/Sample7.java)
    * [Sample7Task.java](../master/src/selenium/sample/Sample7Task.java)
* Styles:
    * [Sample8.java](../master/src/selenium/sample/Sample8.java)
    * [Sample8Task.java](../master/src/selenium/sample/Sample8Task.java)
* Waits:
    * [Sample9.java](../master/src/selenium/sample/Sample9.java)
* Into to Page Object:    
    * [Sample10.java](../master/src/selenium/sample/Sample10.java)
    * [GenericPageSample.java](../master/src/pages/GenericPageSample.java)
    * [MainPageSample.java](../master/src/pages/MainPageSample.java)
    * [PageSample.java](../master/src/pages/PageSample.java)

### Bonuses in case of boredom
* Driver Navigation:
    * [extra1.java](../master/src/selenium/sample/extra/extra1.java)
    * [extra1Task.java](../master/src/selenium/sample/extra/extra1Task.java)
* Using different browsers:
    * [extra2.java](../master/src/selenium/sample/extra2.java)
    * [extra2Task.java](../master/src/selenium/sample/extra2Task.java)


### Getting some files before we start on Task 1
1. Open git bash in the project folder
2. In git bash copy and paste:
```
git fetch
git checkout origin/master -- src/selenium/tasks/ .gitignore
cd src/selenium/sample/
git checkout origin/master -- Sample6.java Sample6Task.java Sample7.java Sample8.java Sample9.java Sample10.java extra/ Sample8Task.java Sample7Task.java
git add .
git commit -m "new files"
git push
cd ../../../
```

### Practical Task 1
Open file “src/selenium/tasks/Task1.java” and complete the TODO
Test page in use: ”Tasks -> Form Task” (https://kristinek.github.io/test-sample/tasks/task1) 
Push all your changes to git


#### Test on locators
https://goo.gl/forms/6AZsHBnvBPkfjuOp2