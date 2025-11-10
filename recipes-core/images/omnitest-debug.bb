LICENSE = "MIT"

inherit core-image testimage

EXTRA_IMAGE_FEATURES += " allow-empty-password empty-root-password allow-root-login post-install-logging "

# bitbake-layers show-recipes --layer meta-oe --recipes-only --inherits ptest

IMAGE_INSTALL += "openssh"

IMAGE_INSTALL += "\
nftables-ptest \
"

QB_MEM = "-m 2048"
IMAGE_ROOTFS_EXTRA_SPACE = "1024288"

