SUMMARY = "Official Python bindings for Selenium WebDriver"
HOMEPAGE = "https://www.selenium.dev"
AUTHOR = "None <None>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../selenium-${PV}.dist-info/METADATA;beginline=5;endline=5;md5=9a6ea5b6c346a830f54cc95f6a2a9245"

SRC_URI += "https://files.pythonhosted.org/packages/c9/0b/5ef429492faa5d951d8215918c7092de2dbc25cf895fdf46643260b22f92/selenium-4.2.0-py3-none-any.whl;downloadfilename=selenium.zip"
SRC_URI[sha256sum] = "ba5b2633f43cf6fe9d308fa4a6996e00a101ab9cb1aad6fd91ae1f3dbe57f56f"

RDEPENDS:${PN} = "python3-urllib3 python3-trio python3-trio-websocket python3-certifi python3-typing-extensions python3-websocket-client"

inherit python3-dir

INSANE_SKIP:${PN} = "already-stripped"

do_install:append(){
  install -d ${D}${PYTHON_SITEPACKAGES_DIR}/selenium
  cp -r ${WORKDIR}/selenium-${PV}.dist-info ${D}${PYTHON_SITEPACKAGES_DIR}/
  cd ${WORKDIR}/selenium
  find . -type f -exec install -D -m 0644 {} ${D}${PYTHON_SITEPACKAGES_DIR}/selenium/{} \;
  chown -R root ${D}${PYTHON_SITEPACKAGES_DIR}
}

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/*"
