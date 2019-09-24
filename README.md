# minefield
```
andrea@marvin:~/src$ ll
drwxrwxr-x 2 andrea andrea 4096 set 24 21:48 ./
drwxrwxr-x 6 andrea andrea 4096 set 24 21:25 ../
-rw-rw-r-- 1 andrea andrea  573 set 24 21:40 Cell.java
-rw-rw-r-- 1 andrea andrea  545 set 24 21:47 Colors.java
-rw-rw-r-- 1 andrea andrea 3942 set 24 21:48 GameMap.java
-rw-rw-r-- 1 andrea andrea 1855 set 24 21:46 MinefieldMain.java
andrea@marvin:~/src$ javac MinefieldMain.java 
andrea@marvin:~/src$ java MinefieldMain
```
```
Minefield size (2-20): 10
Mines number (1+): 8
	0	1	2	3	4	5	6	7	8	9	
0	X	X	X	X	X	X	X	X	X	X	
1	X	X	X	X	X	X	X	X	X	X	
2	X	X	X	X	X	X	X	X	X	X	
3	X	X	X	X	X	X	X	X	X	X	
4	X	X	X	X	X	X	X	X	X	X	
5	X	X	X	X	X	X	X	X	X	X	
6	X	X	X	X	X	X	X	X	X	X	
7	X	X	X	X	X	X	X	X	X	X	
8	X	X	X	X	X	X	X	X	X	X	
9	X	X	X	X	X	X	X	X	X	X	
Row: 0
Col: 0
Elapsed time: 0 minutes and 1 seconds
	0	1	2	3	4	5	6	7	8	9	
0	 	 	 	 	 	 	 	 	 	 	
1	 	 	 	 	 	 	 	1	1	1	
2	 	 	 	 	 	 	 	1	X	X	
3	 	 	 	 	 	 	 	1	X	X	
4	 	1	1	1	 	1	1	1	X	X	
5	 	1	X	1	 	1	X	X	X	X	
6	1	2	1	1	 	1	1	X	X	X	
7	X	1	 	 	 	 	1	X	X	X	
8	1	1	 	 	1	1	2	X	X	X	
9	 	 	 	 	1	X	X	X	X	X	
Row: 9
Col: 9
Elapsed time: 0 minutes and 5 seconds
	0	1	2	3	4	5	6	7	8	9	
0	 	 	 	 	 	 	 	 	 	 	
1	 	 	 	 	 	 	 	1	1	1	
2	 	 	 	 	 	 	 	1	X	X	
3	 	 	 	 	 	 	 	1	X	X	
4	 	1	1	1	 	1	1	1	X	X	
5	 	1	X	1	 	1	X	X	X	X	
6	1	2	1	1	 	1	1	X	X	X	
7	X	1	 	 	 	 	1	X	X	X	
8	1	1	 	 	1	1	2	X	3	2	
9	 	 	 	 	1	X	X	X	1	 	
Row: 7
Col: 9
KABOOM!!!
Elapsed time: 0 minutes and 11 seconds
	0	1	2	3	4	5	6	7	8	9	
0	 	 	 	 	 	 	 	 	 	 	
1	 	 	 	 	 	 	 	1	1	1	
2	 	 	 	 	 	 	 	1	M	1	
3	 	 	 	 	 	 	 	1	1	1	
4	 	1	1	1	 	1	1	1	 	 	
5	 	1	M	1	 	1	M	1	 	 	
6	1	2	1	1	 	1	1	2	2	2	
7	M	1	 	 	 	 	1	2	M	M	
8	1	1	 	 	1	1	2	M	3	2	
9	 	 	 	 	1	M	2	1	1 	 
```
