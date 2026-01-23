#!/bin/bash

branch=$1

echo > prefixed_${branch}

while read line; do
    if grep "$line" ${branch}-new; then
        echo " - [NEW] $line" >> prefixed_${branch}
    else
        echo " - $line" >> prefixed_${branch}
    fi
done < ${branch}

today=`date +%Y-%m-%d`

count_of_all=`grep -cv '^$' ./${branch} | tr -d '\n'`
count_of_removed=`grep -cv '^$' ./${branch}-removed | tr -d '\n'`
count_of_new=`grep -cv '^$' ./${branch}-new | tr -d '\n'`

echo "Subject: CVE report - $branch - $today" > ${branch}.email
echo >> ${branch}.email

echo "Do you see a recipe on this list that is important for you? Help us busting some CVEs by sending some patches." >> ${branch}.email
echo >> ${branch}.email
echo "List of all open CVEs (${count_of_all}, out of which new this week: ${count_of_new}):" >> ${branch}.email

cat prefixed_${branch} >> ${branch}.email

echo >> ${branch}.email
echo "====================" >> ${branch}.email
echo >> ${branch}.email


echo "Removed this week (${count_of_removed}): " >> ${branch}.email
echo >> ${branch}.email

while read line; do
  echo " - ${line}" >> ${branch}.email
done < ${branch}-removed
