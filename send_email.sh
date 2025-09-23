#!/bin/bash

SUBJECT="Pipeline Notification"
BODY=$1

echo "$BODY" | mail -s "$SUBJECT" $EMAIL_DESTINO