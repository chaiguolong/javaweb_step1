
function showPopupAdv(B) {
    this.x = "80px";
    this.y = "220px";
    this.showclosed = 1;
    this.checkclient = 1;
    this.position = 5;
    this.ptime = B.advRotateMs;
    var J = 0;
    var F = this;
    var L;
    this.adv = B;
    this.pdivId = B.advPlace;
    var G = this.adv.advPlace;
    var K = this.adv.advUrl;
    var C = this.adv.advLink;
    var A = this.adv.advParam;
    var I = this.adv.advWidth;
    var E = this.adv.advHeight;
    var D = document.getElementById(G);
    if (D) {
        var H;
        H = "<cite></cite>";
        if (K.toLowerCase().indexOf(".swf") > 0) {
            if (C == "") {
                H = H + "<embed src='" + K + "' width='" + I + "' height='" + E + "' type='application/x-shockwave-flash' wmode='transparent' menu='false'></embed>"
            } else {
                H = H + "<div id='" + G + "' style='margin-bottom: 5px; display: block;width:" + I + "px; height:" + E + "px; position:relative;'><a href='" + C + "' title='' target='_blank' onclick=\"ad_c_m('" + A + "');\" style='display:block;position:absolute;z-index:1;top:0;left:0;width:" + I + "px;height:" + E + "px;background:red;opacity:0;filter:alpha(opacity=0)'>1</a><OBJECT classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0' WIDTH='" + I + "' HEIGHT='" + E + "'><PARAM NAME='movie' VALUE='" + K + "'><PARAM NAME='quality' VALUE='high'><param name='wmode' value='transparent'><EMBED src='" + K + "' wmode='transparent' quality='high' WIDTH='" + I + "' HEIGHT='" + E + "' TYPE='application/x-shockwave-flash' PLUGINSPAGE='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'></EMBED></OBJECT></div>"
            }
        } else {
            if (K.toLowerCase().indexOf(".jpg") > 0 || K.toLowerCase().indexOf(".jpeg") > 0 || K.toLowerCase().indexOf(".gif") > 0 || K.toLowerCase().indexOf(".png") > 0) {
                if (A == "" || A.length < 1) {
                    H = H + "<a href='" + C + "' target=_blank onmousedown=\"return ttclick(this,'tracefrom=" + A + "');\"><img src='" + K + "' width='" + I + "' height='" + E + "' border='0'></a>"
                } else {
                    H = H + "<a href='" + C + "' target=_blank onmousedown=\"return ttclick(this,'tracefrom=" + A + "');\" onclick=\"ad_c_m('" + A + "');\"><img src='" + K + "' width='" + I + "' height='" + E + "' border='0'></a>"
                }
            }
        }
        jQuery("#" + this.pdivId + "").html(H)
    }
    this.init = function() {
        this.width = "500px";
        this.height = "350px";
        jQuery("#" + this.pdivId + "").css({
            position: "absolute",
            zIndex: "9999",
            width: this.width,
            height: this.height,
            overflow: "hidden"
        }).hide();
        this.totalwidth = parseInt(jQuery("#" + this.pdivId + "").css("width")) * 2 + 950;
        if (this.checkclient && this.position != 5) {
            if (document.documentElement.clientWidth < this.totalwidth) {
                jQuery("#" + this.pdivId + "").hide()
            }
        }
        if (this.showclosed) {
            jQuery("#" + this.pdivId + "").html(jQuery("#" + this.pdivId + "").html() + "<img style='display:none;position:absolute;right:5px;top:6px;z-index:2;cursor:pointer;' src='http://i3.dukuai.com/ui/style/09/img/float_ad_closed.gif' class='closedbutton' title='关闭' />")
        }
        if (this.adv.advType != 4) {
            if (this.position == 1) {
                jQuery("#" + this.pdivId + "").css({
                    top: this.y,
                    left: this.x
                })
            }
            if (this.position == 2) {
                jQuery("#" + this.pdivId + "").css({
                    top: this.y,
                    right: this.x
                })
            }
            if (this.position == 3) {
                var M = 0;
                M = document.documentElement.clientHeight - jQuery("#" + this.pdivId + "").height() - this.y;
                jQuery("#" + this.pdivId + "").css({
                    top: M,
                    left: this.x
                })
            }
            if (this.position == 4) {
                var M = 0;
                M = document.documentElement.clientHeight - jQuery("#" + this.pdivId + "").height() - this.y;
                jQuery("#" + this.pdivId + "").css({
                    top: M,
                    right: this.x
                })
            }
        }
        if (this.adv.advType == 8 && this.position == 5) {
            jQuery("#" + this.pdivId + "").css({
                left: "50%",
                top: parseInt(this.y) + document.documentElement.scrollTop + "px",
                marginLeft: -jQuery("#" + this.pdivId + "").width() / 2 + "px"
            })
        }
        this.showad()
    };
    this.closeded = function() {
        jQuery("#float_ad_replay").css({
            left: "0",
            top: document.documentElement.clientHeight + document.documentElement.scrollTop - jQuery("#float_ad_replay").height() - 58 + "px"
        });
        jQuery("#float_ad_replay").attr("lang", "zh");
        if (document.documentElement.clientWidth > 1028) {
            jQuery("#float_ad_replay").show()
        }
        clearTimeout(L);
        jQuery("#" + this.pdivId + " .closedbutton").hide();
        jQuery("#" + this.pdivId + "").hide()
    };
    this.showad = function() {
        if (this.checkclient) {
            jQuery("#" + this.pdivId + "").show()
        }
        if (this.showclosed) {
            setTimeout(this.showbtn, 1000)
        }
        if (F.ptime) {
            L = setTimeout(F.closeded, F.ptime)
        }
    };
    this.showbtn = function() {
        jQuery("#" + this.pdivId + " .closedbutton").fadeIn("slow");
        jQuery("#" + this.pdivId + " .closedbutton").click(function() {
            F.closeded()
        })
    };
    if (this.adv.advType == 8) {
        jQuery("#" + this.pdivId + "").find("cite").css({
            display: "none"
        });
        jQuery(document.body).append("<div id='float_ad_replay'><a hrer='#' class='float_ad_replay' title='重播'>重播</a><a hrer='#' class='float_ad_closed' title='关闭'>关闭</a></div>");
        jQuery("#float_ad_replay .float_ad_small").css({
            position: "relative",
            zIndex: "1",
            overflow: "hidden"
        });
        jQuery("#float_ad_replay a").css({
            display: "block",
            position: "absolute",
            zIndex: "10",
            paddingTop: "16px",
            left: "4px",
            height: "0",
            width: "16px",
            cursor: "pointer",
            overflow: "hidden"
        });
        jQuery("#float_ad_replay .float_ad_closed").css({
            bottom: "4px"
        });
        jQuery("#float_ad_replay .float_ad_replay").css({
            bottom: "25px",
            paddingTop: "74px"
        });
        jQuery("#float_ad_replay").css({
            position: "absolute",
            paddingBottom: "58px",
            height: "100px",
            width: "24px",
            background: "url(http://i3.dukuai.com/ui/style/09/img/float_ad_replay.gif) no-repeat 0 bottom"
        }).hide();
        jQuery("#float_ad_replay .float_ad_replay").click(function() {
            F.init();
            jQuery(this).parent().hide()
        });
        jQuery("#float_ad_replay .float_ad_closed").click(function() {
            jQuery(this).parent().removeAttr("lang", "");
            jQuery(this).parent().hide()
        })
    }
    this.win_reset = function() {
        if (jQuery("#float_ad_replay").attr("lang")) {
            jQuery("#float_ad_replay").css("top", document.documentElement.scrollTop - J + parseInt(jQuery("#float_ad_replay").css("top")) + "px")
        }
        jQuery("#" + this.pdivId + "").css("top", document.documentElement.scrollTop - J + parseInt(jQuery("#" + this.pdivId + "").css("top")) + "px");
        J = document.documentElement.scrollTop
    };
    jQuery(window).scroll(function() {
        setTimeout(F.win_reset, 80)
    });
    jQuery(window).resize(function() {
        if (F.checkclient) {
            if (jQuery("#float_ad_replay").attr("lang")) {
                if (document.documentElement.clientWidth > 1028) {
                    jQuery("#float_ad_replay").show()
                } else {
                    jQuery("#float_ad_replay").hide()
                }
            }
        }
        if (F.adv.advType == 8 && jQuery("#float_ad_replay").attr("lang")) {
            var M = document.documentElement.clientHeight + document.documentElement.scrollTop - jQuery("#float_ad_replay").height() - 58;
            jQuery("#float_ad_replay").css({
                top: M + "px"
            })
        }
        if (F.position == 3 || F.position == 4) {
            var N = document.documentElement.clientHeight + document.documentElement.scrollTop - jQuery("#" + this.pdivId + "").height() - F.y;
            jQuery("#" + this.pdivId + "").css({
                top: N + "px"
            })
        }
    });
    this.init()
}
var top = -14;
var left = 965;




function showFullScreenAdv(A) {
    this._top = top;
    this._left = left;
    this.dtime = A.advRotateMs;
    this.pause = false;
    this.ltime = null;
    var B = this;
    this.adv = A;
    this.divId = A.advPlace;
    this.run = function() {
        jQuery("#" + this.divId + "").html("<a class='fade_btn' ></a><div class='fade_border'></div><div class='fade_main'><img class='fade_closed' src='images/dk_ad_closed.gif' height='19' width='19'/>");
        jQuery("#" + this.divId + " .fade_btn").click(function() {
            B.openad()
        });
        jQuery("#" + this.divId + " .fade_closed").click(function() {
            B.closedad()
        });
        jQuery("#" + this.divId + " .fade_btn").css({
            position: "absolute",
            cursor: "pointer"
        });
        jQuery("#" + this.divId + " .fade_border").css({
            position: "absolute",
            cursor: "pointer"
        });
        jQuery("#" + this.divId + " .fade_closed").css({
            position: "absolute",
            cursor: "pointer"
        });
        jQuery("#" + this.divId + " .fade_btn").css({
            display: "none",
            top: "-14px"
        });
        jQuery("#" + this.divId + " .fade_border").css({
            display: "none",
            top: "-14px"
        });
        jQuery("#" + this.divId + " .fade_btn").css({
            "z-index": "9999",
            left: "952px",
            "text-align": "center",
            width: "52px",
            height: "19px",
            "line-height": "19px",
            "text-align": "center",
            background: "url(images/bn_play.gif)"
        });
        jQuery("#" + this.divId + " .fade_border").css({
            display: "none",
            left: "995px",
            "z-index": "5",
            width: "35px",
            height: "15px",
            border: "2px solid #E5E5E5"
        });
        jQuery("#" + this.divId + " .fade_main").css({
            display: "none",
            width: "950px",
            height: "0",
            overflow: "hidden"
        });
        jQuery("#" + this.divId + " .fade_closed").css({
            "z-index": "1000",
            top: "10px",
            right: "10px"
        });
        this.generateAdvHtml();
        this.openad()
    };
    B.generateAdvHtml = function() {
        var J = this.adv.advPlace;
        var F = this.adv.advUrl;
        var D = this.adv.advLink;
        var H = this.adv.advParam;
        var C = this.adv.advWidth;
        var G = this.adv.advHeight;
        var E = document.getElementById(J);
        if (E) {
            E.style.display = "block";
            if (E.parentNode.style.display == "" || E.parentNode.style.display == "none") {
                E.parentNode.style.display = "block"
            }
            var I;
            if (F.toLowerCase().indexOf(".swf") > 0) {
                if (D == "") {
                    I = "<embed src='" + F + "' width='" + C + "' height='" + G + "' type='application/x-shockwave-flash' wmode='transparent' menu='false'></embed>"
                } else {
                    I = "<div id='" + J + "' style='margin-bottom: 5px; display: block;width:" + C + "px; height:" + G + "px; position:relative;'><a href='" + D + "' title='' target='_blank' onclick=\"ad_c_m('" + H + "');\" style='display:block;position:absolute;z-index:1;top:0;left:0;width:" + C + "px;height:" + G + "px;background:red;opacity:0;filter:alpha(opacity=0)'>1</a><OBJECT classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0' WIDTH='" + C + "' HEIGHT='" + G + "'><PARAM NAME='movie' VALUE='" + F + "'><PARAM NAME='quality' VALUE='high'><param name=wmode value='transparent'><EMBED src='" + F + "' wmode='transparent' quality='high' WIDTH='" + C + "' HEIGHT='" + G + "' TYPE='application/x-shockwave-flash' PLUGINSPAGE='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'></EMBED></OBJECT></div>"
                }
                jQuery("#" + this.divId + " .fade_main").append(I)
            } else {
                if (F.toLowerCase().indexOf(".jpg") > 0 || F.toLowerCase().indexOf(".jpeg") > 0 || F.toLowerCase().indexOf(".gif") > 0 || F.toLowerCase().indexOf(".png") > 0) {
                    if (H == "" || H.length < 1) {
                        I = "<a href='" + D + "' target=_blank onmousedown=\"return ttclick(this,'tracefrom=" + H + "');\"><img src='" + F + "' width='" + C + "' height='" + G + "' border='0'></a>"
                    } else {
                        I = "<a href='" + D + "' target=_blank onmousedown=\"return ttclick(this,'tracefrom=" + H + "');\" onclick=\"ad_c_m('" + H + "');\"><img src='" + F + "' width='" + C + "' height='" + G + "' border='0'></a>"
                    }
                    jQuery("#" + this.divId + " .fade_main").append(I)
                }
            }
        }
    };
    B.openad = function() {
        if (B.pause) {
            return
        }
        B.pause = true;
        jQuery("#" + this.divId + " .fade_btn").show();
        jQuery("#" + this.divId + " .fade_border").show();
        jQuery("#" + this.divId + " .fade_closed").hide();
        clearInterval(B.ltime);
        jQuery("#" + this.divId + " .fade_btn").html(B.dtime / 1000);
        jQuery("#" + this.divId + " .fade_border").animate({
            width: "946px",
            height: "40px",
            left: "0",
            top: "0",
            opacity: "0"
        },
        700,
        function() {
            jQuery(this).hide()
        });
        jQuery("#" + this.divId + " .fade_main").show().animate({
            height: "40px"
        },
        700,
        function() {
            jQuery("#" + B.divId + " .fade_closed").show();
            B.ltime = setInterval(B.resettime, 1000)
        })
    };
    B.closedad = function() {
        clearInterval(B.ltime);
        jQuery("#" + this.divId + " .fade_border").stop();
        jQuery("#" + this.divId + " .fade_main").stop();
        jQuery("#" + this.divId + " .fade_border").show().animate({
            width: "35px",
            height: "15px",
            top: B._top + "px",
            left: B._left + "px",
            opacity: "100"
        },
        700);
        jQuery("#" + this.divId + " .fade_main").animate({
            height: "0"
        },
        700,
        function() {
            jQuery(this).hide();
            jQuery("#" + B.divId + " .fade_btn").show().html("重播");
            B.pause = false
        })
    };
    B.resettime = function() {
        jQuery("#" + this.divId + " .fade_btn").html(jQuery(".fade_btn").html() - 1);
        if (jQuery("#" + this.divId + " .fade_btn").html() == 0) {
            clearInterval(B.ltime);
            B.pause = false;
            B.closedad();
            return
        }
    };
    this.run()
}







(function() {
    var U = [{
        advRotateMs: 2000,
        advPlace: "adv_forum_home_full",
        advParam: "ad_bbs_0804hunbo_950*40",
        advUrl: "images/ad101.jpg",
        advLink: "#",
        advWidth: 950,
        advType: "7",
        advHeight: 40
    }];
    var R = new Array();
    var P = new Object();
    var B = new Array();
    var S = new Array();
    var G = new Array();
    var N = new Array();
    var C = new Object();
    var O = new Object();
    var J = new Array();
    var Q = new Array();
    var D = new Object();
    var A = new Array();
    for (var F = 0; F < U.length; F++) {
        if (U[F].advUrl.toLowerCase().indexOf(".swf") > 0) {
            J[U[F].advPlace] = (J[U[F].advPlace] ? J[U[F].advPlace] : 0) + 1
        }
        Q[U[F].advPlace] = (Q[U[F].advPlace] ? Q[U[F].advPlace] : 0) + 1
    }
    for (F in U) {
        if (U[F].advType == "3") {
            if (Q[U[F].advPlace] == 2 && (J[U[F].advPlace] == 1 || J[U[F].advPlace] == 2)) {
                var K = D[U[F].advPlace] || new Array();
                K.push(U[F]);
                D[U[F].advPlace] = K
            } else {
                var T = C[U[F].advPlace] || new Array();
                T.push(U[F]);
                C[U[F].advPlace] = T
            }
        } else {
            if (U[F].advType == "4") {
                G.push(U[F])
            } else {
                if (U[F].advType == "7") {
                    B.push(U[F])
                } else {
                    if (U[F].advType == "8") {
                        S.push(U[F])
                    } else {
                        if (U[F].advType == "9") {
                            N.push(U[F])
                        } else {
                            if (U[F].advType == "10") {
                                var T = P[U[F].advPlace] || new Array();
                                T.push(U[F]);
                                P[U[F].advPlace] = T
                            } else {
                                if (U[F].advType == "11") {
                                    var L = O[U[F].advPlace] || new Array();
                                    L.push(U[F]);
                                    O[U[F].advPlace] = L
                                } else {
                                    if (U[F].advType == "12") {
                                        A.push(U[F])
                                    } else {
                                        if (U[F].advType == "13") {
                                            R.push(U[F])
                                        } else {
                                            R.push(U[F])
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    for (i in R) {
        var E = R[i];
        if (document.getElementById(E.advPlace)) {
            showAdv(E)
        }
    }
    for (F in G) {
        var E = G[F];
        if (document.getElementById(E.advPlace)) {
            showFloatAdv(E)
        }
    }
    var M = 0;
    for (F in B) {
        var I = B[F];
        if (I.advRotateMs < 1000) {
            I.advRotateMs = 3000
        }
        if (document.getElementById(I.advPlace)) {
            M = I.advRotateMs;
            setTimeout(function() {
                showFullScreenAdv(I)
            },
            2000);
            break
        }
    }
    ADVERTISE.RotateAdv.init(P);
    ADVERTISE.RotateAdv.run();
    ADVERTISE.LoopAdv.init(C);
    ADVERTISE.LoopAdv.run();
    ADVERTISE.ScrollAdv.init(O);
    ADVERTISE.ScrollAdv.run();
    for (F in A) {
        var E = A[F];
        if (document.getElementById(E.advPlace)) {
            showFooterAdv(E)
        }
    }
    ADVERTISE.FoucsLostAdv.init(D);
    ADVERTISE.FoucsLostAdv.run();
    for (F in N) {
        var E = N[F];
        if (document.getElementById(E.advPlace)) {
            showVideoAdv(E)
        }
    }
    for (F in S) {
        var H = S[F];
        pausetime = 2000;
        if (M != 0) {
            pausetime = pausetime + 3000 + parseInt(M)
        }
        if (H.advRotateMs < 1000) {
            H.advRotateMs = 3000
        }
        if (document.getElementById(H.advPlace)) {
            setTimeout(function() {
                showPopupAdv(H)
            },
            pausetime);
            return
        }
    }
})();