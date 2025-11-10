LICENSE = "MIT"

inherit core-image testimage

EXTRA_IMAGE_FEATURES += " allow-empty-password empty-root-password allow-root-login post-install-logging "
IMAGE_FEATURES += "x11-base x11-sato"

# bitbake-layers show-recipes --layer meta-oe --recipes-only --inherits ptest

IMAGE_INSTALL += "openssh"

IMAGE_INSTALL += "clutter-1.0-ptest"

QB_MEM = "-m 2048"
IMAGE_ROOTFS_EXTRA_SPACE = "1024288"

