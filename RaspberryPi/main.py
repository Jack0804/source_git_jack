#!/usr/bin/env python
# -- coding: utf-8 --
import requests
import logging
import logging.handlers
import time
import os
import datetime
import configparser
import Adafruit_DHT as dht
import setting as set
import sendFile as sf
#



# 사진 촬영
def handle_still(dirName, fileName):

    set.writeLog('start handle_still(%s , %s)' %(dirName, fileName))
    if os.path.isdir(dirName):
        pass

    else:
        os.system('mkdir %s' %(dirName))

    try:
        #os.system('sudo raspistill -t 1000 -ISO 400 -ex antishake -o %s/%s -w 1920 -h 1024 -q 20' %(dirName, fileName)
        #os.system('sudo raspistill -t 1000 -ISO 400 -ex antishake -o %s/%s -w 1920 -h 1024 -q 20' %(dirName, fileName))
        #os.system('sudo raspistill -t 1000 -p n -ex sports -o %s/%s -w 1920 -h 1024' %(dirName, fileName))
        os.system('sudo raspistill -ISO 100 -vf -hf -p n -ex auto -t 1500 -rot 90 -o %s/%s -h 1080 -w 1920' %(dirName, fileName))


    except:
        set.writeLog('Error os.system');
    #end handle_still()



# main
def main():

    os.system('sudo shutdown -r 01:00')

    set.writeLog('Start Program')

    global sec
    sec = 60


    while True:

        obj = {"cameraId" : serialNumber}
        res = requests.post('http://14.32.7.115:605/cameraStatus', data = obj)
        res = res.text
        set.writeLog("res =%s" %(res))

        if(res.find('shutdown') != -1) :
         break;

        hour   = datetime.datetime.now().strftime("%H");  # '시' 가져오기
        minute = datetime.datetime.now().strftime("%M");

        if (hour > '01' and  hour < '06') :
            set.writeLog('Start timeSleep hour = %s' %(hour))
            time.sleep((3600*5))

        set.writeLog('Start While')

        date = datetime.datetime.now().strftime("%Y_%m_%d_%H_%M_%S")      # Date
        dirName  = datetime.datetime.now().strftime("/home/pi/jack/%Y_%m_%d")           # PATH
	
	if os.path.isdir(dirName):
            pass

        else:
            os.system('mkdir %s' %(dirName))

        fileName = ('%s_%s.jpg' %(serialNumber, date))

        # Start Picture
        # time.sleep(1)
        handle_still(dirName, fileName) # picture
        # End Picture

        sendFileName = ('%s/%s' %(dirName, fileName))
        print(sendFileName)

        # SendFile
        try :

            ###
            h,t = dht.read_retry(dht.DHT22,4)

            temper= '{0:0.1f}'.format(t)
	    humidity = '{0:0.1f}'.format(h)

            # set.writeLog('temp error')

            set.writeLog('temperature = %s' %(temper))
            set.writeLog('humidity = %s' %(humidity))

            ###
            #print('testfilename = %s' %sendFileName)

            obj = {"cameraId" : serialNumber}
            res = requests.post('http://14.32.7.115:605/cameraStatus', data = obj)
            res = res.text

            #set.writeLog(res)
            #set.writeLog(res.find('time'))

            if( res.find('time') != -1) :
             set.writeLog("start find")
             str = res.split('=')
             set.writeLog(str)
             sec = str[1]

	    if(res == serialNumber) :
             print('kill process')

             while True :

              set.writeLog ("Sleep Process...")

              obj = {"cameraId" : serialNumber}
              res = requests.post('http://14.32.7.115:605/cameraStatus', data = obj)
              res = res.text

              #
              temp = res.split('=')
              set.writeLog("res = %s" %(temp))
              #

              if( res == serialNumber) :
               break;

              time.sleep(10)
              #EndWhile

            if( res.find('time')) :
	     
             str = res.split('=')
             #sec = str[1]
             set.writeLog("sec =%s" %(sec))

            imageFile = open(sendFileName, 'rb')
            sf.send_Image(imageFile, sendFileName, temper, humidity)

            time.sleep(60)

        except IOError:
            set.writeLog ("not open file")

        # EndFile
        # End While
    # End Main


# 시리얼 번호를 얻어온다.
serialNumber = set.getserial()
main()


	

