#!/bin/bash
#Set the variable which equal to zero
prev_count=0

count=$(grep -i "`date --date='yesterday' '+%b %e'`" /var/log/messages | egrep -wi 'warning|error|critical' | wc -l)

if [ "$prev_count" -lt "$count" ] ; then
    # Send a mail to given email id when errors found in log
    SUBJECT="WARNING: Errors found in log on "`date --date='yesterday' '+%b %e'`""
    # This is a temp file, which is created to store the email message.
    MESSAGE="/tmp/logs.txt"
    TO="2daygeek@gmail.com"
    echo "ATTENTION: Errors are found in /var/log/messages. Please Check with Linux admin." >> $MESSAGE
    echo  "Hostname: `hostname`" >> $MESSAGE
    echo -e "\n" >> $MESSAGE
    echo "+------------------------------------------------------------------------------------+" >> $MESSAGE
    echo "Error messages in the log file as below" >> $MESSAGE
    echo "+------------------------------------------------------------------------------------+" >> $MESSAGE
    grep -i "`date --date='yesterday' '+%b %e'`" /var/log/messages | awk '{ $3=""; print}' | egrep -wi 'warning|error|critical' >>  $MESSAGE
    mail -s "$SUBJECT" "$TO" < $MESSAGE
    #rm $MESSAGE
fi