inherit ptest

FILESEXTRAPATHS:prepend := "${THISDIR}/django2:"

SRC_URI += "file://run-ptest \
"

do_install_ptest(){
    cp -r ${S}/tests ${D}${PTEST_PATH}
    sed -i 's,/usr/bin/env python,/usr/bin/env python3,' ${D}${PTEST_PATH}/tests/runtests.py
}

RDEPENDS:${PN}-ptest += " \
    firefox \
    geckodriver \
    gettext \
    python3-bcrypt \
    python3-compile \
    python3-docutils \
    python3-jinja2 \
    python3-misc \
    python3-numpy \
    python3-pillow \
    python3-pyyaml \
    python3-selenium \
    python3-smtpd \
    python3-sqlite3 \
    python3-statistics \
    python3-tblib \
    tzdata \
"
