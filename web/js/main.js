/**
 * 判断开始字符是否是XX
 * 
 * @author zh
 */
$.startWith = function(source, str) {
	var reg = new RegExp("^" + str);
	return reg.test(source);
};
