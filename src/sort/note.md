[算法分析与设计]
[排序稳定性分析](https://zhuanlan.zhihu.com/p/83078338)

排序稳定性：
**要定义一种排序方法的稳定性是根据其排序过程中有没有打乱原始相同数据相对之间顺序。如果打乱了原始相同数据的相对顺序，那么这种排序方法是不稳定的。**

冒泡排序：
比如要按照从小到大排序，每一次遍历都是如果这个数比下一个大的话，就交换，如果两个数相同不交换，所以冒泡排序是一种稳定的排序方法。

插入排序：
待排序元素如果遇到相等的元素会放在相等元素的右边，还是保持原来的相对顺序，所以插入排序也是一种稳定的排序。

选择排序：
选择排序做不到稳定，选择排序是选择当前未排序数据中最小的元素a，与第一个数b进行交换,如果a之前还有一个和b数值相同的元素b',那么b'和b的相对顺序就相反了。比如举个例子：

给定数组[3,4,3,2,1],2和第一个3进行交换，那么排序过程中两个3的相对顺序就被打乱了。

归并排序：
归并排序是一种稳定的排序：

归并排序分解再合并的子过程，分解是不打乱相对顺序的，合并的时候如下：

[3,3,4,6,5]和[3,5,6,7,9]两个子数组需要合并，双指针分别指向两个3，我们只要保证元素相等的时候先拷贝左边数组的指针所指向的数就可以保证不打乱原始相同数据的相对顺序。

快速排序：
快速排序也是一种不稳定的排序算法，在partition过程中做不到稳定。在partition过程中，将比num小的与small区域右边一个数进行交换，比num大的与great区域的左一个数进行交换，而small和great分别在数组两侧，很容易打乱原始数据的相对顺序。

堆排序：
不能保证稳定性。

但堆排序中弹出堆顶元素后的heapify交换的是第一层的结点和最后一层的结点。