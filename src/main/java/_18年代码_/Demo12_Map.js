const input_value = new Map();

/**
 * 字典去重
 * @param value
 */
function addValue(value){
    if (value === undefined)
        return

    if (input_value.get(value) !== undefined){
        input_value.set(value , input_value.get(value) + 1)

        // your do call
        alert("输入重复！" + value)
        return
    }

    input_value.set(value , 0)
}