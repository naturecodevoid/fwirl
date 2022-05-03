#!/bin/bash

rm -r ../docs || true
cp -r .vuepress/dist ../docs
