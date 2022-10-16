//
// Created by sy84l on 2022-10-15.
//


#include "detect_module_8.h"
#include "library_abstract_layer.h"

#include <sys/system_properties.h>
#include <string.h>

typedef struct Property {
    const char* property;
    const char* bad_value;
    int isObligatory;
} Property;

struct Property properties[] = {
        {"ro.debuggable", "1", 1},
        {"service.adb.root", "0", 0},
        {"ro.secure", "1", 1},
        {"sys.initd", "1", 0},
        {"ro.build.selinux", "0", 0},
        {0}
};

static int run_detect()
{
    for(int i = 0; properties[i].property; i++) {
        char value[100] = {0,};
        int length = 0;
        length = sal__system_property_get()(properties[i].property, value);
        //length = __system_property_get(properties[i].property, value);
        if (length > 0) {
            if (strlen(value) >= strlen(properties[i].bad_value) && strstr(value, properties[i].bad_value) != NULL) {
                return DETECTED;
            }
        }
        else {
            if (properties[i].isObligatory == 1) {
                return DETECTED;
            }
        }
    }
    return NOT_DETECTED;
}

detect_module *setup_detect_module_8(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}