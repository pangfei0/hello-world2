Array.prototype.inArray = function(el){ 
for (var i=0,n=this.length;i<n;i++ ) 
if(this[i]===el)return true; 
return false; 
} 
Array.prototype.unique = function() { 
var i = 0, n = this.length,ret = []; 
for (; i < n; i++) 
if (!ret.inArray(this[i])) ret.push(this[i]); 
return ret; 
}; 