# This is the same as do_prepare_config in busybox.inc, but
# it is possible to link busybox statically by setting the
# ENABLE_BUSYBOX_STATIC variable to 1

do_prepare_config () {
        export KCONFIG_NOTIMESTAMP=1

        sed -e '/CONFIG_STATIC/d' \
                < ${WORKDIR}/defconfig > ${S}/.config
        if [ "${@d.getVar('ENABLE_BUSYBOX_STATIC')}" = "1" ]; then
            echo "CONFIG_STATIC=y" >> .config
        else
            echo "# CONFIG_STATIC is not set" >> .config
        fi
        for i in 'CROSS' 'DISTRO FEATURES'; do echo "### $i"; done >> \
                ${S}/.config
        sed -i -e '${configmangle}' ${S}/.config
        if test ${DO_IPv4} -eq 0 && test ${DO_IPv6} -eq 0; then
                # disable networking applets
                mv ${S}/.config ${S}/.config.oe-tmp
                awk 'BEGIN{net=0}
                /^# Networking Utilities/{net=1}
                /^#$/{if(net){net=net+1}}
                {if(net==2&&$0 !~ /^#/&&$1){print("# "$1" is not set")}else{print}}' \
                ${S}/.config.oe-tmp > ${S}/.config
        fi
        sed -i 's/CONFIG_IFUPDOWN_UDHCPC_CMD_OPTIONS="-R -n"/CONFIG_IFUPDOWN_UDHCPC_CMD_OPTIONS="-R -b"/' ${S}/.config
        if [ -n "${DEBUG_PREFIX_MAP}" ]; then
                sed -i 's|${DEBUG_PREFIX_MAP}||g' ${S}/.config
        fi
}

do_prepare_config[vardeps] += "ENABLE_BUSYBOX_STATIC"
