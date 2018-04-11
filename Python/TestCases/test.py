'''
p.getX(): 464, p.getY(): 4506  
elWidth: 148, elHeight: 46 

        imgHeight: 966
imgHeightReminder: 5
   elementRecalcX: 464
   elementRecalcY: 65
   elementRecalcDX: 0.24382553862322648
   elementRecalcDY: 4.6645962732919255
   documentHeight: 5060
   documentWidth: 1903
   

'''

p_getY= 4506  
PageHeight = 966
imgHeightReminder= 5
DocumentHeight= 5060


a = (p_getY//PageHeight)
a1 = (p_getY/PageHeight)  + 0.1909
b = (PageHeight*imgHeightReminder)
c = (DocumentHeight/PageHeight)
d = (PageHeight/DocumentHeight)
print(" a: {}".format(a))
print("a1: {}".format(a1))
print(" b: {} ".format( b))
print(" c: {} ".format( c))
print(" d: {} ".format( d))

