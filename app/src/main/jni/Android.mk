LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := detectEngine
FILES := 	detect_engine.c 			\
			detect_module_1.c 			\
			detect_module_2.c			\
			detect_module_3.c			\
			detect_module_4.c			\
			detect_module_5.c			\
			detect_module_6.c			\
			detect_module_7.c			\
			detect_module_8.c			\
			detect_module_9.c			\
			library_abstract_layer.c	\
			ctest.c

LOCAL_SRC_FILES := $(FILES)
include $(BUILD_SHARED_LIBRARY)
