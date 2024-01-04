from tkinter import *
from pygame import mixer
from tkinter import filedialog
from tkinter import messagebox
from  mutagen.mp3 import MP3
import time
import threading
import os

thread=False
playing=False
def play_music():
    global playing
    global t

    try:
        mixer.music.load(filename.name)
        mixer.music.play()
        bottom_status['text']='Playing music....'
        mid_label['text']='Music :'+os.path.basename(filename.name)

        playing=True
        t1 = threading.Thread(target=start_count, args=(t,))
        t1.setDaemon(True)
        t1.start()
        c_scale.configure(to=t)
        play_btn.configure(image=pause,command=pause_music)

    except:
        messagebox.showinfo('Music Not Fonund','Please Select a Song from File ')
        playing=False
        play_btn.configure(image=play, command=play_music)


def stop_music():
    mixer.music.stop()
    global current_time
    current_time=0
    play_btn.configure(image=play, command=play_music)
    bottom_status['text'] = 'Music Stopped ......'

paused=False
def pause_music():
    global paused
    if paused==False:
        mixer.music.pause()
        paused=True
        play_btn.configure(image=play)
        bottom_status['text'] = 'Music Paused......'
    else:
        mixer.music.unpause()
        paused = False
        play_btn.configure(image=pause)
        bottom_status['text'] = 'Playing Music......'


def volume(val):
    vol=int(val)/100.0
    mixer.music.set_volume(vol)


muted=False
def mute_music():
    global muted
    if muted==False:
        sc.set(0)
        val=0
        mixer.music.set_volume(val)
        mute_btn.configure(image=mute_pic)
        muted=True
    else:
        sc.set(50)
        val = 50
        mixer.music.set_volume(val)
        mute_btn.configure(image=unmute_pic)
        muted = False

t=0.0
count=0
def open_files():
    global t
    global thread
    global current_time
    global filename
    filename=filedialog.askopenfile()
    t=0

    global count

    current_time=0

    if (os.path.splitext(filename.name)[1][1:].strip().lower()=='mp3'):
        a=MP3(filename.name)
        t=a.info.length

    else:
        a = mixer.Sound(filename.name)
        t = a.get_length()
    if count%2==0:
        thread=True
        count=count+1
    else:
        thread=False
        count = count + 1
    mini, sec = divmod(t, 60)
    lenght_label['text'] = 'Total Lenght:{:02d}:{:02d}'.format(round(mini), round(sec))
    stop_music()
    play_music()


current_time=0

def start_count(t):
    global paused
    global thread
    global current_time
    current_time=0
    while current_time<=t and mixer.music.get_busy():
        if(thread==False):
            thread=True
            break
        if paused:
            continue
        else:
            mini, sec = divmod(current_time, 60)
            current_label['text'] = 'Current Lenght:{:02d}:{:02d}'.format(round(mini), round(sec))
            time.sleep(1)
            current_time= current_time + 1
            val = current_time
            c_scale.set(val)






root=Tk()
mixer.init()
#root.geometry('500x300')
root.title('Singhplay')
root.iconbitmap('img/musicicon.ico')
root.resizable(0,0)

frame_top=Frame(root,relief='groove',bd='2',padx='10',pady='10')
frame_top.pack(side='top',fill='x')

frame_mid=Frame(root,relief='groove',bd='2',padx='10',pady='10')
frame_mid.pack(fill='x')

frame_bot=Frame(root,relief='groove',bd='2')
frame_bot.pack(side='bottom',fill='x')

main_manu=Menu(root)
root.config(menu=main_manu)

file_menu=Menu(main_manu,tearoff=0)
main_manu.add_cascade(menu=file_menu,label='File')
file_menu.add_command(label='Open',command=open_files)
file_menu.add_command(label='Exit',command=exit)

help_menu=Menu(main_manu,tearoff=0)
main_manu.add_cascade(menu=help_menu,label='Help')
help_menu.add_command(label='About Us')


play=PhotoImage(file='img/play.png')
pause=PhotoImage(file='img/pause.png')
stop=PhotoImage(file='img/Stop-icon.png')
unmute_pic=PhotoImage(file='img/unmute.png')
mute_pic = PhotoImage(file='img/mute.png')

play_btn=Button(frame_top,image=play,command=play_music)
play_btn.pack(side='left',padx='20')
stop_btn=Button(frame_top,image=stop,command=stop_music)
stop_btn.pack(side='left',padx='20')
mute_btn=Button(frame_top,image=unmute_pic,command=mute_music)
mute_btn.pack(side='left',padx='20')


sc=Scale(frame_bot,fg='red',orient='horizontal',command=volume)
sc.set(50)
mixer.music.set_volume(0.5)
sc.pack()

mid_label=Label(frame_mid,text='Shivam singh')
mid_label.pack()

lenght_label=Label(frame_mid,text='Total Lenght :00:00')
lenght_label.pack()

current_label=Label(frame_mid,text='Current Lenght:   00:00')
current_label.pack()

c_scale=Scale(frame_mid,from_=0,to=t,orient='horizontal')
c_scale.set(0)
c_scale.pack(fill='x')

bottom_status=Label(frame_bot,text='Welcome to SinghPlay',bd=2,font='arial 15 bold',anchor='w',padx='20')
bottom_status.pack(side='bottom',fill='x')

def onclosing():
    stop_music()
    try:
        root.destroy()
    except:
        root.destroy()

root.protocol('WM_DELETE_WINDOW',onclosing)
root.mainloop()