<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>home</title>
<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
        Remove this if you use the .htaccess --><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>music</title>
<script type="text/javascript" src="js/jQuery/jquery.js">
</script>
<script type="text/javascript" src="js/drawing/base.js">
</script>
<script type="text/javascript" src="js/drawing/clef.js">
</script>
<script type="text/javascript" src="js/drawing/timeSignature.js">
</script>
<script type="text/javascript" src="js/drawing/accidental.js">
</script>
<script type="text/javascript" src="js/drawing/note.js">
</script>
<script type="text/javascript" src="js/drawing/rest.js">
</script>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+path+"/";
%>
<base href="<%=basePath %>">

</head>
    <body>
        <div>
            <header>
                <h1>Drawing tests</h1>
            </header>
            <div>
                <canvas id="score" width="1600" height="850">
                </canvas>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready( function() {
                $('#score').each( function() {
                    var ctx = buildContext(this);
                    drawStaff(ctx, {'x': 0, 'y': 0}, {'width': 800});		//五线谱
                    drawTrebleClef(ctx, {'x': 10, 'y': 0});					//高音符号
                    drawSharp(ctx, {'x': 35, 'y': 3.625});					//#
                    drawSharp(ctx, {'x': 44, 'y': 14.55});					//#
                    drawSharp(ctx, {'x': 53, 'y': 0});						//#
                    drawCommonTime(ctx, {'x': 70, 'y': 0});					//C
                    drawWholeNote(ctx, {'x': 100, 'y': 22.25});				//O
					drawTabZero(ctx, {'x': 130, 'y': 10}, {'scale': 2});
                   //第二条
					drawStaff(ctx, {'x': 0, 'y': 50}, {'width': 800});
                    drawBassClef(ctx, {'x': 10, 'y': 50});					//低音符号
                    drawFlat(ctx, {'x': 35, 'y': 75.9});					//b
                    drawFlat(ctx, {'x': 44, 'y': 64.6});
                    drawCutCommonTime(ctx, {'x': 61, 'y': 50});				//C|

                    drawStaff(ctx, {'x': 0, 'y': 100}, {'width': 400});
                    drawAltoClef(ctx, {'x': 10, 'y': 100});
                    drawTwo(ctx, {'x': 35, 'y': 100});
                    drawFour(ctx, {'x': 35, 'y': 114.9});
                    //drawNatural(ctx, {'x': 50, 'y': 100});

                    drawHalfNoteHead(ctx, {'x': 80, 'y': 100 + (12 * 3.67)});
                    drawRightStem(ctx, {'x': 80, 'y': 100 + (12 * 3.67)});
                    drawHalfNoteHead(ctx, {'x': 120, 'y': 100 + (6 * 3.67)});
                    drawLeftStem(ctx, {'x': 120, 'y': 100 + (6 * 3.67)});

                    drawBarSeparator(ctx, {'x': 160, 'y': 100});

                    drawHalfNoteHead(ctx, {'x': 180, 'y': 100 + (5 * 3.67)});
                    drawLeftStem(ctx, {'x': 180, 'y': 100 + (5 * 3.67)});
                    drawHalfNoteHead(ctx, {'x': 220, 'y': 100 + (4 * 3.67)});
                    drawLeftStem(ctx, {'x': 220, 'y': 100 + (4 * 3.67)});

                    drawBarSeparator(ctx, {'x': 260, 'y': 100});

                    drawNoteHead(ctx, {'x': 280, 'y': 100 + (6 * 3.67)});
                    drawLeftStem(ctx, {'x': 280, 'y': 100 + (6 * 3.67)});
                    drawNoteHead(ctx, {'x': 300, 'y': 100 + (4 * 3.67)});
                    drawLeftStem(ctx, {'x': 300, 'y': 100 + (4 * 3.67)});
                    drawBottomFlag(ctx, [{'x': 280, 'y': 100 + (6 * 3.67)}, {'x': 300, 'y': 100 + (4 * 3.67)}]);

                    drawNoteHead(ctx, {'x': 320, 'y': 100 + (5 * 3.67)});
                    drawLeftStem(ctx, {'x': 320, 'y': 100 + (5 * 3.67)});
                    drawDot(ctx, {'x': 320, 'y': 100 + (4 * 3.67)});

                    drawNoteHead(ctx, {'x': 350, 'y': 100 + (13 * 3.67)});
                    drawNoteNeck(ctx, {'x': 350, 'y': 100 + (13 * 3.67)});
                    drawRightStem(ctx, {'x': 350, 'y': 100 + (13 * 3.67)});
                    drawSingleFlagDown(ctx, {'x': 350, 'y': 100 + (13 * 3.67)});

                    drawStaff(ctx, {'x': 0, 'y': 150}, {'width': 400});
                    drawTabClef(ctx, {'x': 10, 'y': 150});
                    drawThree(ctx, {'x': 35, 'y': 150});
                    drawFour(ctx, {'x': 35, 'y': 164.9});

                    drawStaff(ctx, {'x': 0, 'y': 200}, {'width': 400});
                    drawPercussionsClef(ctx, {'x': 10, 'y': 200});
                    drawSix(ctx, {'x': 35, 'y': 200});
                    drawEight(ctx, {'x': 35, 'y': 214.5});
                    drawWholeNote(ctx, {'x': 60, 'y': 225});

                    var scale = 5.0;//五线谱的比例
                    drawStaff(ctx, {'x': 0, 'y': 250}, {'width': 400, 'scale': scale});				//五线谱
                    drawTabClef(ctx, {'x': 10 * scale, 'y': 250}, {'scale': scale});				//A B 
                    drawCommonTime(ctx, {'x': 40 * scale, 'y': 250}, {'scale': scale});				//C
                    drawTabZero(ctx, {'x': 70 * scale, 'y': 250}, {'scale': scale});
                    drawTabOne(ctx, {'x': 70 * scale, 'y': 250 + 7.34 * scale}, {'scale': scale});
                    drawTabTwo(ctx, {'x': 70 * scale, 'y': 250 + 7.34 * 2 * scale}, {'scale': scale});
                    drawTabThree(ctx, {'x': 90 * scale, 'y': 250}, {'scale': scale});
                    drawTabFour(ctx, {'x': 90 * scale, 'y': 250 + 7.34 * scale}, {'scale': scale});
                    drawTabFive(ctx, {'x': 90 * scale, 'y': 250 + 7.34 * 2 * scale}, {'scale': scale});
                    drawTabSix(ctx, {'x': 90 * scale, 'y': 250 + 7.34 * 3 * scale}, {'scale': scale});
                    drawTabSeven(ctx, {'x': 90 * scale, 'y': 250 + 7.34 * 4 * scale}, {'scale': scale});
                    drawTabEight(ctx, {'x': 110 * scale, 'y': 250}, {'scale': scale});
                    drawTabNine(ctx, {'x': 110 * scale, 'y': 250 + 7.34 * scale}, {'scale': scale});
                    drawTrebleClef(ctx, {'x': 10 * scale, 'y': 250}, {'scale': scale});				//高音符号
                    drawSharp(ctx, {'x': 35 * scale, 'y': 250 + 3.625 * scale}, {'scale': scale});  //#	
                    drawSharp(ctx, {'x': 44 * scale, 'y': 250 + 14.55 * scale}, {'scale': scale});	//#
                    drawSharp(ctx, {'x': 53 * scale, 'y': 250 + 0}, {'scale': scale});					//#
                    drawCommonTime(ctx, {'x': 70 * scale, 'y': 250}, {'scale': scale});						//C
                    drawHundredTwentyEighthRest(ctx, {'x': 90 * scale, 'y': 250}, {'scale': scale});
                });
            }
            );
        </script>
    </body>
</html>