

/*
*
* ECMAScript
*
* 制定得 javaScript 规范
*
* */

// 变量
var a;
// 局部变量
let v1;
// 常量
const v2 = 1;
//字符串模板
const aa = `
    111
    222
    333
`;

// 解构 表达式
const v3 = [1,2,3,4];
const [a1,a2,a3] = v3;
//demo2
let persion = {name: "a" , age: 11};
const {name , age} = persion;
// 别名
const {name:a , age:b} = persion;

// 函数优化
// 默认值
function m1(a,b = 1){
    /*if (!b){
        b = 1;
    }*/
    // 如果b 不等于空
    b = b || 1;
    console.log(a/b)
}

// 箭头函数
// 类似 lambda 表达式
()=>{}

let v4 = v1 => console.log(v1);
v4(10);


// 函数式编程
// 3中写法
const v5 = {
    name: "66",
    q : function () {
        console.log("66")
    },
    // this的域 就不同的
    // 箭头函数不包含 this
    // 指待 上一级
    q2 : () => {
        console.log(this.name)
    },
    q3(){
        console.log(this.q())
    }
};
v5.q();

// 箭头函数 结合 解构表达式

const v5 = {
    name: "1",
    age: 1
};

v6 = ({name,age}) => {
    console.log(name + age);
};
v6(v5);


//map 和 reduce
//map
// 接收 一个 函数 一个参数
// 将原数组 数据 处理后 然后用 新数组返回
let v7 = [1,2,3,4];
var map = v7.map(r => r*10);

//reduce
// 接收 一个函数 和一个初始值（可选）
// v7.reduce(func , <int> )
// 这个func 可以 接收 俩参数
// reduce 会把数组中的元素 从左 到右依次处理
// 然后 将 这个结果给下次reduce的第一个参数
var reduce = v7.reduce( (r1, r2) => r1 + r2);
// 可选参数
// 就是 给第一个参数 赋值初始值
var reduce = v7.reduce( (r1, r2) => r1 + r2 , 100);


// 对象Object (万物皆对象)
// 方法
// keys 返回key数组
// values  返回value数组
//entries 返回k + v 数组
//assign 拷贝 // 浅拷贝 将数据 拷贝到 第一个参数对象里面
// 可以接收多个参数

const v8 = {name : "1" , age : 2};
var keys = Object.keys(v8);
keys = Object.values(v8);


// 数组扩展
// 方法
//find // 找出 第一个 符合条件的元素
// 找到 返回true
//没有 undefind
// findIndex //返回第一个位置
// includes //接收一个数组 与find类似

let v9 = [1,23,4,5,6,7];
let find = v9.find(a => a === 23);
let v10 = {name : "1" , age : 2};

var find1 = v10.find(r => r.age === 2);












