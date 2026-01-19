LICENSE = "MIT"

inherit core-image testimage

EXTRA_IMAGE_FEATURES += " allow-empty-password empty-root-password allow-root-login post-install-logging "

# bitbake-layers show-recipes --layer meta-oe --recipes-only --inherits ptest

IMAGE_INSTALL += "openssh"
IMAGE_INSTALL += "python3-django-ptest"

QB_MEM = "-m 2048"
