cmake_minimum_required(VERSION 3.4.1)

file(GLOB my_source_path src/main/cpp/*.cpp src/main/cpp/*.c)

#添加模块
add_library( #模块名
            kotlin-native
            #动态库
            SHARED
            #源文件
            ${my_source_path}
)

#需要链接或者编译的库
target_link_libraries(kotlin-native)

