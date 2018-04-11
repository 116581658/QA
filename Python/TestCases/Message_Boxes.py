import tkinter
#import ctypes  # Another library for message boxes, but simple one


##### The following code works with ctypes BEGIN #########
# def mbox(title, text, style):
#     ctypes.windll.user32.MessageBoxW(0, text, title, style)
# mbox('Your title', 'Your text', 1)

# ##  Styles:
# ##  0 : OK
# ##  1 : OK | Cancel
# ##  2 : Abort | Retry | Ignore
# ##  3 : Yes | No | Cancel
# ##  4 : Yes | No
# ##  5 : Retry | No
# ##  6 : Cancel | Try Again | Continue

##### The following code works with ctypes END #########

from tkinter import *
# if you are working under Python 3, comment the previous line and comment out the following line
#from tkinter import *

root = Tk()

w = LabelFrame(root, text="Hello Tkinter!")
# w.pack()

root.mainloop()
