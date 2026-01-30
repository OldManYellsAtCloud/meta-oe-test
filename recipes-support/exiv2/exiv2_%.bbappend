inherit ptest

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://run-ptest \
            file://0001-Allow-test-data-path-configuration.patch \
            file://0001-Fix-build-with-gtest-1.11.patch"

DEPENDS += "${@bb.utils.contains('PTEST_ENABLED', '1', 'googletest', '', d)}"

RDEPENDS:${PN}-ptest += " \
    python3-html \
    python3-lxml \
    python3-multiprocessing \
    python3-shell \
    python3-unittest"

EXTRA_OECMAKE = "\
    ${@bb.utils.contains('PTEST_ENABLED', \
    '1', \
    '-DEXIV2_BUILD_SAMPLES=ON -DEXIV2_ENABLE_WEBREADY=ON -DEXIV2_BUILD_UNIT_TESTS=ON -DTEST_FOLDER=${PTEST_PATH}', \
    '', \
    d)} \
"

do_install_ptest(){
    cp -r ${S}/tests ${D}${PTEST_PATH}/
    cp -r ${S}/test ${D}${PTEST_PATH}/

    install -d ${D}${PTEST_PATH}/build/bin
    install ${B}/bin/* ${D}${PTEST_PATH}/build/bin

    install -d ${D}${PTEST_PATH}/src
    install ${S}/src/canonmn_int.cpp ${D}${PTEST_PATH}/src
}

