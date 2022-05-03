#!/bin/bash

rm -r ../docs-dist || true
cp -r .vuepress/dist ../docs-dist
