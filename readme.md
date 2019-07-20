# PiMesuem-Game-ChineseChess 

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)

[**Chinese Chess**](https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E8%B1%A1%E6%A3%8B/278314?fr=aladdin)

## 象棋的数学模型
### **棋盘:**    
* 棋盘为 **10行9列**，映射数学模型为二维坐标系，因存在棋谱记法(炮二平四，车六进三等)，以己方为视角，正对棋盘，从 **右往左依** 次为 **1至9列** ，**从下往上** 依次为 **1至10行** ，因此建立 **XY** 轴二维坐标系。

* 从 **右向左为** 为 **X轴** 正方向，从 **从下往上** 为 **Y轴** 正方向，且以棋盘右下角坐标为（x=1,y=1，则棋盘左上角的坐标为（x=9,y=10)，与棋谱记录法一一对应，对方棋盘视角可通过棋盘中心点（x = (9-1)/2，y=(10-1)/2) 即 (x=4,y=4.5)
旋转180度换算成己方视角。

* 棋子落点则为以棋盘为基础的坐标系上的点，是二维坐标系内一个离散有限集合，即10*9 = 90个坐标点，是棋盘的一个固定数据。 

### **棋子:**  
* 棋子起始共有32个 ，棋子附有坐标位置属性，棋子被棋盘所持有，我们称之棋子集合为R,棋子的可落点坐标即为对R的约束。

* 棋子具有移动的功能，根据不同棋子的特性产生移动行为后，会对棋子集合R产生处理，并且移动前会被落点数据上的其他棋子约束（比如马蹩脚），移动后的结果会对棋盘的落点分配有影响。 

* 棋子区分红方和黑方，减少集合R的唯一行为本质是红旗和黑棋占用同一落子的坐标位置，且只能是前者被后者移除。

### **下棋:**
* 即回合制对棋子使用移动功能，在移动前根据棋子规则对棋盘进行查询，满足条件即可产生移动，对棋子进行可落子的可能遍历，功能执行结束后从新审视棋盘情况。 

## 象棋的数据结构设计

### **映射数据模型:**

* 棋盘为全局对象，一个可被有序操作的类，包含一个被固定坐标数据约束的棋子对象集合，持有一个全局方法或者操作对象，每一次回合的操作即使对棋子对象集合产生2种主要行为：删除棋子对象，改变棋子对象的坐标属性。

* 棋子为数据对象，基础属性为坐标，基本方法为改变坐标值，不同的棋子则为棋子基础类的派生类，可重写其改变坐标的方法，或者每个棋子对象包含一个约束类，监听棋盘对象的坐标占用情况，计算出改变坐标的值是否满其移动的前置条件。

* 下棋为操作对象或者是棋盘对象存在的全局方法，每一次对集合R的处理结果通过定义的规则利用游戏引擎渲染到Ui。

### Tips 
* 基本单击操作的象棋数据结构设计如此(整个过程因为集合是小于或等于32的，单次对数据做全遍历操作，在耗时上没有直观区别，但是程序可以通过对棋子对象的列，横向索引排序，对棋子对象的移动行为做可达性分析和优化，减少对数据的查询量，操作量，还有轨迹记录分析，不能走3遍旧棋，设计电脑Ai等)

**Continue Optimizing**... [Jiervs](https://github.com/Jiervs)

