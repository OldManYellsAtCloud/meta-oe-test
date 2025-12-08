LICENSE = "MIT"

inherit core-image testimage

EXTRA_IMAGE_FEATURES += " allow-empty-password empty-root-password allow-root-login post-install-logging "

# bitbake-layers show-recipes --layer meta-oe --recipes-only --inherits ptest

IMAGE_INSTALL += "openssh"

IMAGE_INSTALL += "asio-ptest \
cli11-ptest \
cmocka-ptest \
cunit-ptest \
duktape-ptest \
fftw-ptest \
fmt-ptest \
function2-ptest \
\
fwupd-ptest \
gcab-ptest \
inotify-tools-ptest \
jemalloc-ptest \
kernel-selftest-ptest \
keyutils-ptest \
leveldb-ptest \
libcereal-ptest \
\
libdbi-perl-ptest \
libee-ptest \
libgpiod-ptest \
libjcat-ptest \
libmanette-ptest \
libssh-ptest \
libteam-ptest \
libxml++-ptest \
\
libxml++-5.0-ptest \
libxmlb-ptest \
libyang-ptest \
lmdb-ptest \
mcelog-ptest \
neon-ptest \
nlohmann-json-ptest \
onig-ptest \
\
oprofile-ptest \
ostree-ptest \
poco-ptest \
protobuf-ptest \
pv-ptest \
rocksdb-ptest \
rsyslog-ptest \
sdbus-c++-ptest \
uthash-ptest \
xmlsec1-ptest \
zchunk-ptest \
zeromq-ptest \
\
python3-ansicolors-ptest \
python3-appdirs-ptest \
python3-aspectlib-ptest \
python3-blinker-ptest \
python3-cachetools-ptest \
python3-cbor2-ptest \
python3-click-ptest \
python3-dnspython-ptest \
python3-dominate-ptest \
python3-fastjsonschema-ptest \
python3-geojson-ptest \
python3-gunicorn-ptest \
python3-html2text-ptest \
python3-inflection-ptest \
python3-intervals-ptest \
python3-ipy-ptest \
python3-iso3166-ptest \
python3-jdcal-ptest \
python3-jsmin-ptest \
python3-license-expression-ptest \
python3-lz4-ptest \
python3-msgpack-ptest \
python3-multidict-ptest \
python3-ordered-set-ptest \
python3-parse-ptest \
python3-parse-type-ptest \
python3-pillow-ptest \
python3-pint-ptest \
python3-polyline-ptest \
python3-precise-runner-ptest \
python3-prettytable-ptest \
python3-ptyprocess-ptest \
python3-py-cpuinfo-ptest \
python3-pyasn1-modules-ptest \
python3-pyroute2-ptest \
python3-pyserial-ptest \
python3-pytest-lazy-fixture-ptest \
python3-pytoml-ptest \
python3-pyyaml-include-ptest \
python3-requests-file-ptest \
python3-requests-toolbelt-ptest \
python3-scrypt-ptest \
python3-semver-ptest \
python3-serpent-ptest \
python3-simpleeval-ptest \
python3-smpplib-ptest \
python3-soupsieve-ptest \
python3-sqlparse-ptest \
python3-typeguard-ptest \
python3-u-msgpack-python-ptest \
python3-ujson-ptest \
python3-unidiff-ptest \
python3-uritemplate-ptest \
python3-whoosh-ptest \
python3-xlrd-ptest \
python3-xmltodict-ptest \
python3-xxhash-ptest \
python3-yappi-ptest \
python3-yarl-ptest \
\
squid-ptest \
\
libauthen-radius-perl-ptest \
libauthen-sasl-perl-ptest \
libcapture-tiny-perl-ptest \
libcgi-perl-ptest \
libconfig-autoconf-perl-ptest \
libcrypt-openssl-guess-perl-ptest \
libcrypt-openssl-random-perl-ptest \
libcrypt-openssl-rsa-perl-ptest \
libdata-hexdump-perl-ptest \
libdbd-sqlite-perl-ptest \
libdigest-hmac-perl-ptest \
libdigest-sha1-perl-ptest \
libextutils-config-perl-ptest \
libextutils-installpaths-perl-ptest \
libfile-slurper-perl-ptest \
libhtml-parser-perl-ptest \
libhtml-tagset-perl-ptest \
libio-socket-ssl-perl-ptest \
libmime-types-perl-ptest \
libnet-dns-perl-ptest \
libnet-ldap-perl-ptest \
libstrictures-perl-ptest \
libsub-uplevel-perl-ptest \
libterm-readkey-perl-ptest \
libtest-deep-perl-ptest \
libtest-harness-perl-ptest \
libtest-nowarnings-perl-ptest \
libtest-warn-perl-ptest \
libtest-warnings-perl-ptest \
libunicode-linebreak-perl-ptest \
libunix-statgrab-ptest \
libxml-libxml-perl-ptest \
\
freediameter-ptest \
geoip-ptest \
geoip-perl-ptest \
libnftnl-ptest \
lksctp-tools-ptest \
net-snmp-ptest \
openhpi-ptest \
openl2tp-ptest \
python3-scapy-ptest \
squid-ptest \
tcpdump-ptest \
\
libopenmpt-ptest \
\
fuse3-ptest \
sshfs-fuse-ptest \
\
audiofile-ptest \
imagemagick-ptest \
\
xrdp-ptest \
gssdp-ptest \
gupnp-ptest \
gupnp-av-ptest \
gupnp-igd-ptest \
"

QB_MEM = "-m 2048"
IMAGE_ROOTFS_EXTRA_SPACE = "1024288"

