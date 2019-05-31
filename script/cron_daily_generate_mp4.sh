#!/bin/bash

#batch
#located in cdn
#check path

for f in *; do
    if [ -d ${f} ]; then
        ffmpeg -y -pix_fmt yuv420p -pattern_type glob -i "$f/*.png" -vf "setpts=10*PTS" $f.mp4
        echo $f
    fi
done
