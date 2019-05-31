#!/bin/bash

#$1 = photoPath, $2 = productId
#TODO modify payload (info)

curl -i -X POST -H "Content-Type: multipart/form-data"  -F "photo=@$1" -F "info=Lat:30.2,Lon:31.2/T:26℃/H:45%/Light:198,DOV:88%" http://landvibe.cafe24.com:8888/products/$2
