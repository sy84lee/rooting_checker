LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := detectEngine
FILES := 	detect_engine.c 	\
			detect_module_1.c 	\
			detect_module_2.c	\
			detect_module_3.c	\
			detect_module_4.c	\
			detect_module_5.c	\
			detect_module_6.c	\
			detect_module_7.c
LOCAL_SRC_FILES := $(FILES)
include $(BUILD_SHARED_LIBRARY)
