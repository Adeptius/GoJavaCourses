
My result is:

--------------------------------------------------------------------------------------------------------------------------------------
TimeUnit is: MICROSECONDS
Test is running for: 100|500|10000 operations
All tests repeated 20 times for better precision
                 add              get              remove           contains         populate         iterator.add     iterator.remove
ArrayList        94|77|414        7|21|172         24|24|170        161|394|29500    8|36|342         25|49|688        80|142|21183
LinkedList       30|50|394        28|78|43968      27|26|220        156|377|211790   3|17|289         18|82|326        59|54|382
HashSet          80|114|1517                       45|86|1156       33|73|993        16|67|974
TreeSet          228|516|2745                      80|156|2095      21|74|2264       14|78|3034
--------------------------------------------------------------------------------------------------------------------------------------
Test result is saved to: Z:\test result.txt