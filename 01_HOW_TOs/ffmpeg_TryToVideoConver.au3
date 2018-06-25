Merchant details:
    API Key: UPPUP3XQP3XNBNSAPQDW21FbekMk8sjFIMMiW4YdlDpls7u4Y
    externalClientId: 06373056-91f5-6149-e70b-11581620ed01


name|value
_checkout.sdk.url|https://sandbox-assets.secure.checkout..com/checkout-widget/resources/js/integration/v1/sdk.js
_checkout.external.client.id|06373056-91f5-6149-e70b-11581620ed01
_checkout.button.url|https://sandbox.secure.checkout..com/wallet-services-web/xo/button.png
_checkout.api.key|UPPUP3XQP3XNBNSAPQDW21FbekMk8sjFIMMiW4YdlDpls7u4Y

-i %input -c:v libx264 -preset slow -crf 34 -an %output
TFS_9094-trunk-tag-STYLE_DEP-_first_deposit.tst

ffmpeg -i Billing_details_Validation.avi -crf 28 Billing_details_Validation.mp4
ffmpeg -i Billing_details_Validation.avi -c:v libx264 -preset slow -crf 28 -an Billing_details_Validation.mp4


ffmpeg -i DrillDown.mp4 -c:v libx264 -preset slow -crf 34 -an DrillDown_2.mp4



ffmpeg -i INPUT.avi -crf 23 OUTPUT.mp4
>>> ffmpeg -i INPUT.avi OUTPUT.mp4
>>> ffmpeg -i INPUT.avi -q 23 OUTPUT.mp4
>>> ffmpeg -i INPUT.avi -crf 23 OUTPUT.mp4

Targeting the AUDIO:
>>> ffmpeg -i INPUT.mp3 -b:a 320k OUTPUT.mp3

Targeting the VIDEO:
>>> ffmpeg -i INPUT.avi -b:v 1000k OUTPUT.mp4

BOTH
>>> ffmpeg -i INPUT.avi -b:v 1000k -b:a 128k OUTPUT.mp4

CROPPING

Previewing the cropping area:
>>>ffplay -i input.mp4 -vf "crop=in_w:in_h:x:y"
>>>ffplay -i Video.mp4 -vf "crop=600:700:400:0"
>>>ffplay -i DEMO.avi -vf "crop=1085:1000:25:35"


Cropping:
>>>ffmpeg -i in.mp4 -filter:v "crop=out_w:out_h:x:y" out.mp4
>>>ffmpeg -i in.mp4 -filter:v "crop=out_w:out_h:x:y" out.mp4
>>>ffmpeg -i DEMO.avi -filter:v "crop=1085:1000:27:38" _out.mp4
>>>ffmpeg -i DEMO.avi -filter:v "crop=1085:1000:27:38" _out.mp4
ffmpeg -i DEMO.avi -vf "crop=1085:1000:27:38" -c:v libx264 -crf 17 -c:a copy ouput.mp4


>>> ffmpeg -i INPUT.avi -filter:v "crop=w=640:h=480:x=100:y=200" OUTPUT.mp4

>>> ffmpeg -i input.png -vf chromakey=green out.png - Make every green pixel in the input image transparent:
>>> ffmpeg -i Billing_details_Validation.avi -vf chromakey=green Billing_details_Validation.png - Make every green pixel in the input image transparent:


ffmpeg -f gdigrab -offset_x 0 -offset_y 0 -video_size 1920x1080 -i desktop -vcodec h264 my-screen-only.mp4
ffmpeg -f gdigrab -offset_x 0 -offset_y 0 -video_size 1920x1080 -i desktop -vcodec libx264 -preset slow -crf 28 my-screen-only2.mp4

CUTTING:
ffmpeg -ss [start] -i in.mp4 -t [duration] -c:v libx264 -c:a aac -strict experimental -b:a 128k out.mp4

ffmpeg -i AquiringFraudReport_FlagOn.avi -ss 00:00:00 -t 00:50:00 -c copy AquiringFraudReport_FlagOn_.avi
ffmpeg -ss 00:08:00 -i Video.mp4 -ss 00:01:00 -t 00:01:00 -c copy VideoClip.mp4
ffmpeg -ss 00:00:00 -i AquiringFraudReport_FlagOn.avi -t 00:50:00 -c copy AquiringFraudReport_FlagOn_.avi
The first -ss seeks fast to (approximately) 8min0sec, and then the second -ss seeks accurately to 9min0sec, and the -t 00:01:00 takes out a 1min0sec clip.


ping -n 5 -l 1500 https://srv-bsf-devcpatrunk.gw-4u.com

Test Case 12171:

	10413
	0 = DISABLED, 1 = ENABLED, 2 = DELETED, 3 = SUSPENDED, 4 = RESTRICTED

	126806
CUT
ffmpeg -i in.mp4 -ss [start] -t [duration] -c copy out.mp4
ffmpeg -ss [start] -i in.mp4 -t [duration] -c:v libx264 -c:a aac -strict experimental -b:a 128k out.mp4
ffmpeg -y -i in.mp4 -ss [start] -t [duration] -vcodec libx264 -crf 0 -preset placebo out.mp4               <===== CUT with EXACT times !!!! Very Good

	Part 1 Till : Frame 3239 (0:02:41.950) [ ]
	Part 1 Till : Frame 3262 (0:02:43.100) [ ]
	Part 1 Till : Frame 3266 (0:02:43.300) [ ]
	ffmpeg -i DEMO_cropped.mp4 -ss [0:00:00.000] -t 00:02:43.300 -c copy out.mp4
	ffmpeg -i DEMO_cropped.mp4 -ss 00:02:45.500 -t 00:04:03.500 -c copy out_cropp_Part2.mp4
	ffmpeg -i DEMO_cropped.mp4 -ss 00:02:42.400 -t 00:04:06.600 -c copy out_cropp_Part2.mp4

	Part 2 START: Frame 3310 (00:02:45.500) [ ]
	ffmpeg -i DEMO_cropped.mp4 -ss 00:02:45.500 -to 00:06:48.950 -c copy out_cropp_Part2.mp4
	ffmpeg -i DEMO_cropped.mp4 -ss 00:02:42.300 -c copy out_cropp_Part2.mp4
	ffmpeg -i out_cropp_Part2.mp4 -ss 00:00:00.100 -c copy out_cropp_Part3.mp4
	ffmpeg -i out_cropp_Part2.mp4 out_cropp_Part3.mp4
	ffmpeg -i out_cropp_Part3.mp4 -ss 00:00:00.000 -c copy out_cropp_Part4.mp4



	ffmpeg -i "DEMO_original - Copy.avi" -ss 00:02:43.900 -c copy out_original_Part2.mp4



CONCATENATE
ffmpeg -f concat -i ConcaTinataFiles.txt -c copy _Concat.mp4

========================
http://www.mpabo.com/2014/12/14/ffmpeg-and-x264-encoding-guide/

50 MB * 8192 [converts MB to kilobits]) / 600 seconds = ~683 kilobits/s total bitrate
683k - 128k (desired audio bitrate) = 555k video bitrate

ffmpeg -y -i input -c:v libx264 -preset medium -b:v 120k -pass 1 -an -f mp4 NUL && \
ffmpeg -i input -c:v libx264 -preset medium -b:v 120k -pass 2 -c:a libfdk_aac -b:a 128k output.mp4


ffmpeg -y -i apiKeyExternalId.mp4 -c:v libx264 -preset medium -b:v 120k -pass 1 -an -f mp4 NUL && \
ffmpeg -i apiKeyExternalId.mp4 -c:v libx264 -preset medium -b:v 120k -pass 2 -c:a libfdk_aac -b:a 0k C:\01_Myfiles\Captures\output.mp4

2.25 * 8192 = 18432   = 1000
              2500 = x
x = (1000 * 2500)/18432


ffmpeg -i apiKeyExternalId.mp4 -c:v libx264 -b:v 190k output_.mp4


ffmpeg -y -i source.mp4 -r 25 -s 160x90 -c:v libx264 -b:v 3M -strict -2 -movflags faststart destination.mp4
-y : overwrite output files without asking
-i source.mp4 : input file name
-r 25 : output frame rate (in frames per second)
-s 160x90 : output frame size (in pixel) - inserts the scale video filter
-c:v libx264 : output video encoder
-c:v is short for -codec:v and -vcodec
-b:v 3M : video bitrate (in bit/s) passed to libx264 encoder
-strict -2 : governs standards compliance; -2 allows experimental features - required to enable native FFmpeg AAC audio encoder in builds older than version 2015-12-05, see here, AAC is now the default audio encoder.
-movflags faststart : move the index to the beginning of the output file (mov and mp4 format specific parameter)




ffmpeg -y -i apiKeyExternalId.mp4 -r 25 -c:v libx264 -b:v 60k -strict -2 -movflags faststart destination.mp4


ffmpeg -y -i AcqiuringFraudReport_FlagOFF.mp4 -ss 0:00:02.000 -t 00:00:40.300 -c copy AcqiuringFraudReport_FlagOFF_.mp4

ffmpeg -ss 0:00:02.000 -i AcqiuringFraudReport_FlagOFF.mp4 -t 00:00:41.300 -c:v libx264 -strict experimental 128k out.mp4

Optional

=============Video to Images:
# Output one image every second, named out1.png, out2.png, out3.png, etc.:

>>>ffmpeg -i ToRefilm_17601_This_002.mp4 -vf fps=20 out%06d.png

Output one image every ten minutes:
ffmpeg -i test.flv -vf fps=1/600 thumb%04d.bmp

=============Images to Video:
To create a video from a set of images:

>>>ffmpeg -i image-%06d.png video.webm

